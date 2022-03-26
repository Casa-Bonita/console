package com.casabonita.spring.pathsAndDirectories;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для преобразования названия папки в путь до JSON-файла
 */
public class MakePath {

    public List<String> createPath()
    {
        StringBuilder stringBuilder = new StringBuilder();

        String startPath = "C:\\Users\\Home\\IdeaProjects\\working\\Console\\src\\main\\java\\com\\casabonita\\spring\\jsons\\";
        String endPath = ".json";

        Directories[] directories = Directories.values();

        List<String> pathList = new ArrayList<>();

        for (int i = 0; i < directories.length; i++)
        {
            stringBuilder.append(startPath).append(directories[i].toString().toLowerCase()).append(endPath);
            pathList.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }

        return pathList;
    }
}
