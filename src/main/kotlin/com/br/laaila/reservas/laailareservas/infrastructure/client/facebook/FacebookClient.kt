package com.br.laaila.reservas.laailareservas.infrastructure.client.facebook

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@FeignClient("facebook")
interface FacebookClient {

//    @RequestMapping(method = [RequestMethod.GET], value = ["/v7.0/dialog/oauth"])
//    fun getToken(
//            @RequestParam("client_id") client_id: String,
//            @RequestParam("redirect_uri") redirect_uri: String,
//            @RequestParam("state") state: String,
//            @RequestParam("response_type") response_type: String,
//            @RequestParam("scope") scope: String
//    )

}