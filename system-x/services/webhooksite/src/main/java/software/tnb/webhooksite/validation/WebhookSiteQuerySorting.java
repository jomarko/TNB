package software.tnb.webhooksite.validation;

public enum WebhookSiteQuerySorting {
    OLDEST("oldest"),
    NEWEST("newest");

    private String value;

    WebhookSiteQuerySorting(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

