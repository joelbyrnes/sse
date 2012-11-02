package com.adeptusproductions.sse.traceroute

class IPInfoDB {

    // get location from
    // http://api.ipinfodb.com/v3/ip-city/?key=eae8f4ad112e1c1ab1dc1715f4e30e2464d723f441415c68cc3aa83f6a88033d&ip=cjw.dyndns.biz
    // OK;;176.9.140.228;DE;GERMANY;BAYERN;NUREMBERG;-;49.4478;11.0683;+02:00

    String key

    public IPInfoDB(String key) {
        this.key = key
    }

    // cheating: just returning the whole JSON string.
    // we should really parse it. JSON or XML?
    public String searchJSON(String host) {
        return new URL(makeURL(key, host, "json")).text
    }

    private String makeURL(key, host, format) {
        return "http://api.ipinfodb.com/v3/ip-city/?key=${key}&ip=${host}&format=${format}"
    }
}
