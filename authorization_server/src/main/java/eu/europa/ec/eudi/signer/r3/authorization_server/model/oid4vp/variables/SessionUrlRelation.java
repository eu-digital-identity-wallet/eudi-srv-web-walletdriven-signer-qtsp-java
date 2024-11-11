/*
 Copyright 2024 European Commission

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

      https://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.
 */

package eu.europa.ec.eudi.signer.r3.authorization_server.model.oid4vp.variables;

public class SessionUrlRelation {
    private String cookieSessionId;
    private String urlToReturnTo;

    public SessionUrlRelation(String urlToReturnTo, String cookieSessionId) {
        this.urlToReturnTo = urlToReturnTo;
        this.cookieSessionId = cookieSessionId;
    }

    public String getUrlToReturnTo() {
        return urlToReturnTo;
    }

    public void setUrlToReturnTo(String urlToReturnTo) {
        this.urlToReturnTo = urlToReturnTo;
    }

    public String getCookieSessionId() {
        return cookieSessionId;
    }

    public void setCookieSessionId(String cookieSessionId) {
        this.cookieSessionId = cookieSessionId;
    }
}
