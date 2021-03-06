/*
 * Copyright 2016-2017 Huawei Technologies Co., Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openo.sdnhub.acwanservice.moco;

import org.openo.sdno.testframework.http.model.HttpRquestResponse;
import org.openo.sdno.testframework.moco.MocoHttpServer;
import org.openo.sdno.testframework.moco.responsehandler.MocoResponseHandler;

public class L3vpnGetForAcWanDriverServer extends MocoHttpServer {

    public L3vpnGetForAcWanDriverServer() {
        super();
    }

    public L3vpnGetForAcWanDriverServer(String configFile) {
        // super(configFile);
    }

    @Override
    public void addRequestResponsePairs() {
        this.addRequestResponsePair("src/integration-test/resources/AcWanDriverSvc/moco/getDevice.json",
                new AcWanL3vpnGetResponseHandler());
        this.addRequestResponsePair("src/integration-test/resources/AcWanDriverSvc/moco/queryController.json",
                new AcWanL3vpnGetResponseHandler());
        this.addRequestResponsePair("src/integration-test/resources/AcWanDriverSvc/moco/authentication.json",
                new AcWanL3vpnGetResponseHandler());
        this.addRequestResponsePair("src/integration-test/resources/AcWanDriverSvc/moco/getL3vpn.json",
                new AcWanL3vpnGetResponseHandler());
        this.addRequestResponsePair("src/integration-test/resources/AcWanDriverSvc/moco/ESRGetController.json",
                new AcWanL3vpnGetResponseHandler());
    }

    private class AcWanL3vpnGetResponseHandler extends MocoResponseHandler {

        @Override
        public void processRequestandResponse(HttpRquestResponse httpObject) {

        }
    }

}
