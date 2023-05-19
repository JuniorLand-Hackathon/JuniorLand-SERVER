package com.hackerton.junior.service;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.hackerton.junior.domain.Education;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public final class EducationInfoProvider {
    private final Logger logger = LoggerFactory.getLogger(EducationInfoProvider.class);
    @Value("${api.key}")
    private String KEY;

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final String APPLICATION_NAME = "Gdsc-Hackerton";

    public List<Education> getInfos(List<String> urls) {
        try {
            final YouTube.Videos.List search = makeClient(urls);

            return search.execute().getItems().stream()
                    .map(Education::from)
                    .toList();
        } catch (Exception e) {
            logger.error("Youtube API Error: ", e);
            throw new IllegalArgumentException("잘못된 동영상 정보입니다.");
        }
    }

    private YouTube.Videos.List makeClient(final List<String> urls) throws IOException {
        final YouTube.Videos.List search = new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, request -> {
        })
                .setApplicationName(APPLICATION_NAME)
                .build()
                .videos()
                .list(List.of("id, contentDetails"));

        search.setKey(KEY);
        search.setId(urls);
        search.setFields("items(id, contentDetails/duration)");
        return search;
    }
}
