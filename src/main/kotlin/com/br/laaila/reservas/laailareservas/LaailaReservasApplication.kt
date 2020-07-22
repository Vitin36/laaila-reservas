package com.br.laaila.reservas.laailareservas

import org.apache.logging.log4j.LogManager
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.i18n.LocaleContextHolder
import java.net.InetAddress
import java.time.LocalDateTime
import java.util.*

@SpringBootApplication
open class LaailaReservasApplication

fun main(args: Array<String>) {    val logger = LogManager.getLogger(LaailaReservasApplication::class.java);

    TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"))

    val app = runApplication<LaailaReservasApplication>(*args) {
        setLogStartupInfo(true)
    }

    val applicationName = app.environment.getProperty("spring.application.name")
    val contextPath = app.environment.getProperty("server.servlet.context-path")
    val port = app.environment.getProperty("server.port")
    val hostAddress = InetAddress.getLocalHost().hostAddress
    val applicationVersion = app.environment.getProperty("server.version")
    val currentTime = LocalDateTime.now().toString()
    val defaultLocale = LocaleContextHolder.getLocale().toString()

    logger.info(
            """|
                   |------------------------------------------------------------
                   |Application '$applicationName' is running! Access URLs:
                   |   Local:      http://127.0.0.1:$port$contextPath
                   |   External:   http://$hostAddress:$port$contextPath
                   |   Version:    $applicationVersion
                   |   Current:    $currentTime
                   |   Locale:     $defaultLocale
                   | 
                   |------------------------------------------------------------""".trimMargin()
    )
}
