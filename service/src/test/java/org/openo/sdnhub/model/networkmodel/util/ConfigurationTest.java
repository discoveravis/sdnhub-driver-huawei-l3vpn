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

package org.openo.sdnhub.model.networkmodel.util;

import static org.junit.Assert.assertEquals;

import mockit.Mock;
import mockit.MockUp;

import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.openo.baseservice.remoteservice.exception.ServiceException;
import org.openo.sdnhub.acwanservice.config.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationTest {

    @Test
    public void testTransformModel() throws ServiceException {
        new MockUp<IOUtils>() {

            @Mock
            public String toString(InputStream input) throws IOException {
                return "temp";
            }
        };
        new MockUp<ObjectMapper>() {

            @Mock
            public <T> Object readValue(byte[] content, Class<T> valueType)
                    throws IOException, JsonParseException, JsonMappingException {
                List<Map<String, String>> mapList = new ArrayList<>();
                Map<String, String> map = new HashMap<>();
                map.put("cfgkey", "label");
                map.put("cfgvalue", "cfgvalue");
                mapList.add(map);
                return mapList;
            }
        };
        String result = Configuration.getValues("label");
        assertEquals(result, "cfgvalue");
    }

    @Test
    public void testTransformModelBranch() throws ServiceException {

        new MockUp<IOUtils>() {

            @Mock
            public String toString(InputStream input) throws IOException {
                return "temp";
            }
        };
        new MockUp<ObjectMapper>() {

            @Mock
            public <T> Object readValue(byte[] content, Class<T> valueType)
                    throws IOException, JsonParseException, JsonMappingException {
                List<Map<String, String>> mapList = new ArrayList<>();
                Map<String, String> map = new HashMap<>();
                map.put("cfgkey", null);
                map.put("cfgvalue", "cfgvalue");
                mapList.add(map);
                return mapList;
            }
        };
        String result = Configuration.getValues("label");
        assertEquals(result, null);
    }

    @Test
    public void testTransformModelBranch1() throws ServiceException {

        new MockUp<IOUtils>() {

            @Mock
            public String toString(InputStream input) throws IOException {
                return "temp";
            }
        };
        new MockUp<ObjectMapper>() {

            @Mock
            public <T> Object readValue(byte[] content, Class<T> valueType)
                    throws IOException, JsonParseException, JsonMappingException {
                List<Map<String, String>> mapList = new ArrayList<>();
                Map<String, String> map = new HashMap<>();
                map.put("cfgkey", "xyz");
                map.put("cfgvalue", "cfgvalue");
                mapList.add(map);
                return mapList;
            }
        };
        String result = Configuration.getValues("label");
        assertEquals(result, null);
    }
}
