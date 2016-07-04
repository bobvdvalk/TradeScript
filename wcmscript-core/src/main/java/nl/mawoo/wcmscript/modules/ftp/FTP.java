/**
 * Copyright 2016 Mawoo Nederland
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
package nl.mawoo.wcmscript.modules.ftp;

import org.apache.commons.net.ftp.FTPClient;

/**
 * This class is responsible to connect to a FTP server.
 *
 * @author Bob van der Valk
 */
public class FTP {
    private String host;
    private String user = "anonymous";
    private String pass = "anonymous@domain.com";
    private int port = "21";

    /**
     * Set a host for the connection
     * @param host IP or domain name in String
     * @return this for chaining
     */
    public FTP setHost(String host) {
        this.host = host;
        return this;
    }

    /**
     * Set a username for the connection
     * @param username of the remote server
     * @return this for chaining
     */
    public FTP setUsername(String username) {
        this.user = username;
        return this;
    }

    /**
     * Set a password for the connection
     * @param password of the remote server
     * @return this for chaining in Javascript
     */
    public FTP setPassword(String password) {
        this.pass = password;
        return this;
    }

    /**
     * Set a port of the server other then the default 21 port
     * @param port of the remote server
     * @return this for chaining in Javascript;
     */
    public FTP setPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * Open the connection
     */
    public void connect() {
        FTPClient ftpClient = new FTPClient();
        
    }

}
