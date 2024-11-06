package eu.europa.ec.eudi.signer.r3.resource_server.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import eu.europa.ec.eudi.signer.r3.resource_server.web.dto.CredentialsInfo.CredentialsInfoAuth;
import eu.europa.ec.eudi.signer.r3.resource_server.web.dto.CredentialsInfo.CredentialsInfoCert;
import eu.europa.ec.eudi.signer.r3.resource_server.web.dto.CredentialsInfo.CredentialsInfoKey;
import jakarta.validation.constraints.NotBlank;

public class CredentialsInfoResponse {
    private String description;
    private String signatureQualifier;
    private CredentialsInfoKey key;
    private CredentialsInfoCert cert;
    private CredentialsInfoAuth auth;

    private String SCAL = "1"; // 1 | 2

    @NotBlank
    private int multisign; // >= 1
    private String lang;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSignatureQualifier() {
        return signatureQualifier;
    }

    public void setSignatureQualifier(String signatureQualifier) {
        this.signatureQualifier = signatureQualifier;
    }

    public CredentialsInfoKey getKey() {
        return key;
    }

    public void setKey(CredentialsInfoKey key) {
        this.key = key;
    }

    public CredentialsInfoCert getCert() {
        return cert;
    }

    public void setCert(CredentialsInfoCert cert) {
        this.cert = cert;
    }

    public CredentialsInfoAuth getAuth() {
        return auth;
    }

    public void setAuth(CredentialsInfoAuth auth) {
        this.auth = auth;
    }

    @JsonProperty("SCAL")
    public String getSCAL() {
        return SCAL;
    }

    public void setSCAL(String SCAL) {
        this.SCAL = SCAL;
    }

    public int getMultisign() {
        return multisign;
    }

    public void setMultisign(int multisign) {
        this.multisign = multisign;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "CredentialsInfoResponse{" +
                "description='" + description + '\'' +
                ", signatureQualifier='" + signatureQualifier + '\'' +
                ", key='" + key.toString() +
                ", cert='" + cert.toString()+
                ", auth='" + auth.toString() +
                ", SCAL='" + SCAL + '\'' +
                ", multisign=" + multisign +
                ", lang='" + lang + '\'' +
                '}';
    }
}
