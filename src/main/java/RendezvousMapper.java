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

public class RendezvousMapper implements Mapper {
    private int serversCount;

    @Override
    public void setServersCount(int serversCount) {
        this.serversCount = serversCount;
    }

    @Override
    public int server(String key) {
        long maxHash = Long.MIN_VALUE;
        int maxHashServer = -1;

        for (int server = 0; server < serversCount; server++) {
            long hash = Math.abs(murmur3(key, server));

            System.out.println(hash);

            if (hash > maxHash) {
                maxHash = hash;
                maxHashServer = server;
            }
        }

        return maxHashServer;
    }
}
