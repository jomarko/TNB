package software.tnb.webhooksite.account;

import software.tnb.common.account.Account;
import software.tnb.common.account.WithId;

import java.util.Map;

/**
 * Requires following webhooksite account definition:
 *
 *   slack-tnb:
 *     credentials:
 *       uuid: [uuid]
 */
public class WebhookSiteAccount implements Account, WithId {
    private String baseUrl;
    private String uuid;

    @Override
    public String credentialsId() {
        return "webhooksite-tnb";
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
