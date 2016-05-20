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
package nl.mawoo.wcmscript.modules.filesystem;

import nl.mawoo.wcmscript.AbstractScriptModule;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * This module is responsible for most file system operations.
 *
 * @author Bob van der Valk
 */
public class FileSystem extends AbstractScriptModule {


    public void delete(String file) throws IOException {
        Path path = path(file);

        if (Files.isDirectory(path)) {
            deleteFolder(file);
        } else {
            deleteFile(file);
        }
    }

    public void deleteFile(String file) throws IOException {
        Files.delete(path(file));
    }

    public void deleteFolder(String folder) throws IOException {
        Files.walkFileTree(
                path(folder),
                new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        return super.visitFile(file, attrs);
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        return super.postVisitDirectory(dir, exc);
                    }
                }
        );
    }

    private Path path(String path) {
        return Paths.get(path);
    }
}
