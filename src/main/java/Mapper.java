/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.nio.charset.Charset;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

public interface Mapper {
    void setServersCount(int serversCount);

    int server(String key);

    default long murmur3(Object... data) {
        Hasher hasher = Hashing.murmur3_128().newHasher();

        for (Object obj : data) {
            if (obj instanceof Integer) {
                hasher.putInt((Integer)obj);
            }
            else if (obj instanceof String) {
                hasher.putString((CharSequence)obj, Charset.defaultCharset());
            }
            else {
                throw new IllegalStateException("Invalid type: " + obj.getClass());
            }
        }

        return hasher.hash().asLong();
    }
}
