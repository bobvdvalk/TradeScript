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
package nl.mawoo.wcmscript.modules.customfile;

import nl.mawoo.wcmscript.AbstractScriptModule;

import java.io.*;

public class CustomFile extends AbstractScriptModule{
    private Object content;
    private File file;

    /**
     * Creates a new temporary file
     * @param fileName
     * @param content
     * @return
     */
    public CustomFile newFile(String fileName, Object content){
        this.content = content;

        file = new File(fileName);

        return this;
    }

    /**
     * opens a file
     * @param fileName
     */
    public void open(String fileName){
        File file = new File(fileName);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = null;
            while ((line = reader.readLine()) != null) {
                getScriptLogger().info(line);
            }

        } catch (IOException e){
            getScriptLogger().error(e.getMessage());
        }
    }

    /***
     * saves Temporary file to given path and name
     */
    public void save(){
        try {

            if(!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fileWriter);

            bw.write((String) content);
            bw.close();

        } catch (IOException e) {
            getScriptLogger().error(e.getMessage());
        }
    }
}
