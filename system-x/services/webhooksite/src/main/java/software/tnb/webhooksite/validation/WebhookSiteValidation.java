package software.tnb.webhooksite.validation;

import software.tnb.webhooksite.account.WebhookSiteAccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import io.restassured.RestAssured;

public class WebhookSiteValidation {
    private static final Logger LOG = LoggerFactory.getLogger(WebhookSiteValidation.class);

    private final WebhookSiteAccount account;

    public WebhookSiteValidation(WebhookSiteAccount account) {
        this.account = account;
    }

    public List<WebhookSiteRequest> getRequests(WebhookSiteQuerySorting sorting) {
        return RestAssured.get(account.getBaseUrl() + "/token/{webhookUuid}/requests?sorting={sorting}", account.getUuid(), sorting.getValue())
            .then()
            .log().ifValidationFails()
            .statusCode(200)
            .extract()
            .body()
            .jsonPath().getList("data", WebhookSiteRequest.class);
    }

    public void deleteRequest(final WebhookSiteRequest request) {
        RestAssured
            .given()
            .delete(account.getBaseUrl() + "/token/{webhookUuid}/request/{requestUuid}",
                account.getUuid(),
                request.getUuid())
            .then()
            .log().ifValidationFails()
            .statusCode(200);
    }
}
