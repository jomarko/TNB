package software.tnb.webhooksite.service;

import software.tnb.webhooksite.validation.WebhookSiteValidation;
import software.tnb.common.account.Accounts;
import software.tnb.common.service.Service;
import software.tnb.webhooksite.account.WebhookSiteAccount;

import org.junit.jupiter.api.extension.ExtensionContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.auto.service.AutoService;

@AutoService(WebhookSite.class)
public class WebhookSite implements Service {
    private static final Logger LOG = LoggerFactory.getLogger(WebhookSite.class);

    private WebhookSiteAccount account;

    private WebhookSiteValidation validation;

    public WebhookSiteAccount account() {
        if (account == null) {
            LOG.debug("Creating new WebhookSite account");
            account = Accounts.get(WebhookSiteAccount.class);
        }
        return account;
    }

    public WebhookSiteValidation validation() {
        return validation;
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
//        if (client != null) {
//            LOG.debug("Closing Slack client");
//            client.close();
//        }
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        LOG.debug("Creating new Slack validation");
        validation = new WebhookSiteValidation(account());
    }
}
