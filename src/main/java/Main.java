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

public class Main {
    private static final String[] KEYS = new String[] {
        "3018-6500-3832-7967",
        "3535-8042-9707-9496",
        "3580-9535-1215-0386",
        "3559-3211-4085-9306",
        "3547-8357-5853-7362",
        "5020-9153-4497-1698",
        "3026-0087-8643-6365",
        "5010-1226-0854-0174",
        "3578-1820-2518-6448"
    };

    public static void main(String[] args) {
        run(new BasicMapper(), 3);
        run(new BasicMapper(), 4);
        run(new RendezvousMapper(), 3);
        run(new RendezvousMapper(), 4);
    }

    private static void run(Mapper mapper, int serversCnt) {
        System.out.println(mapper.getClass().getSimpleName() + ", " + serversCnt + " servers");

        mapper.setServersCount(serversCnt);

        for (String key : KEYS) {
            System.out.println("  " + key + " -> " + mapper.server(key));
        }

        System.out.println();
    }
}
