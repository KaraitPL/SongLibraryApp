package com.example.songlibraryapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SongLibraryAppGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SongLibraryAppGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routeLocator(
			RouteLocatorBuilder builder,
			@Value("${song-library-app.songs.url}") String songsUrl,
			@Value("${song-library-app.singers.url}") String singersUrl,
			@Value("${song-library-app.gateway.host}") String host
	) {
		return builder
				.routes()
				.route("singers", route -> route
						.host(host)
						.and()
						.path(
								"/api/singers",
								"/api/singers/{uuid}"
						)
						.uri(singersUrl)
				)
				.route("songs", route -> route
						.host(host)
						.and()
						.path(
								"/api/songs",
								"/api/songs/{uuid}",
								"/api/singers/{uuid}/songs"
						)
						.uri(songsUrl)
				)
				.build();
	}

}
