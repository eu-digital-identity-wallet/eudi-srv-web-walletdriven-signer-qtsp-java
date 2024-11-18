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

import java.util.Objects;

public class VerifierCreatedVariable {
    private String nonce;
    private String presentation_id;

    public VerifierCreatedVariable(String nonce, String presentation_id) {
        this.nonce = nonce;
        this.presentation_id = presentation_id;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getPresentation_id() {
        return presentation_id;
    }

    public void setPresentation_id(String presentation_id) {
        this.presentation_id = presentation_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VerifierCreatedVariable that)) return false;
        return Objects.equals(nonce, that.nonce) && Objects.equals(presentation_id, that.presentation_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nonce, presentation_id);
    }
}