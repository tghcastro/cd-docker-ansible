package com.example.demo.acceptance.stepsDefinition;


import com.example.demo.BookEntity;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class BooksSearchSteps {
    private String endpoint;
    private BookEntity testBook;
    private BookEntity gottenBook;

    public BooksSearchSteps() {
        endpoint = "http://localhost:8080/api/v1/books";
    }

    @Given("an existent book")
    public void anExistentBook() throws IOException {
        BookEntity aBook = new BookEntity();
        aBook.setAuthor("Tolkien");
        aBook.setTitle("Lord of the Rings");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(aBook);

        HttpPost request = new HttpPost(endpoint);
        request.addHeader("Content-Type", "application/json");
        request.addHeader("Accept", "application/json");
        request.setEntity(new StringEntity(json));

        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(
                response.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_CREATED));

        testBook = responseToObject(response, BookEntity.class);
    }

    @When("I search by its Id")
    public void iSearchByItsId() throws IOException {
        String getBookEndpoint = endpoint + "/" + testBook.getId();
        HttpGet request = new HttpGet(getBookEndpoint);
        request.addHeader("Accept", "application/json");

        CloseableHttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(
                response.getStatusLine().getStatusCode(),
                equalTo(HttpStatus.SC_OK));

        gottenBook = responseToObject(response, BookEntity.class);
    }

    @Then("I should get the book details")
    public void iShouldGetTheBookDetails() {
        assertThat(gottenBook, equalTo(testBook));
    }

    private <T> T responseToObject(CloseableHttpResponse response, Class<T> valueType) throws IOException {
        String jsonFromResponse = EntityUtils.toString(response.getEntity());
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.readValue(jsonFromResponse, valueType);
    }
}
