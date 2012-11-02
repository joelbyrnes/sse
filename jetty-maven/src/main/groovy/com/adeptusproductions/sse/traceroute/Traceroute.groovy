package com.adeptusproductions.sse.traceroute


class Traceroute {

    public static eachHop(String host, Closure closure) {

        /*
        * traceroute to cjw.dyndns.biz (176.9.140.228), 64 hops max, 52 byte packets
 1  10.205.64.1 (10.205.64.1)  8.866 ms  11.384 ms  19.244 ms
 2  58.160.16.198 (58.160.16.198)  20.945 ms  9.549 ms  19.012 ms
 3  58.160.23.226 (58.160.23.226)  12.195 ms  8.418 ms  7.627 ms
 4  172.18.241.105 (172.18.241.105)  10.470 ms  10.361 ms  12.044 ms
 5  bundle-ether10-woo10.brisbane.telstra.net (110.142.226.13)  15.005 ms  19.132 ms  13.710 ms
 6  bundle-ether3.woo-core1.brisbane.telstra.net (203.50.11.52)  14.680 ms  11.657 ms  11.963 ms
 7  tengige0-8-0-5-1.cha-core4.brisbane.telstra.net (203.50.6.217)  11.228 ms  16.290 ms  8.903 ms
 8  bundle-ether11.ken-core4.sydney.telstra.net (203.50.11.72)  28.911 ms  37.600 ms  35.883 ms
 9  bundle-ether1.pad-gw2.sydney.telstra.net (203.50.6.29)  25.792 ms  26.018 ms  35.662 ms
10  tengige10-0-0.sydp-core02.sydney.reach.com (203.50.13.94)  23.927 ms  33.636 ms  24.025 ms
11  i-0-0-2-0.tlot-core01.bx.telstraglobal.net (202.84.140.78)  184.158 ms  185.224 ms  184.806 ms
12  i-0-4-0-4.tlot02.bi.telstraglobal.net (202.40.149.166)  179.562 ms  182.883 ms  181.214 ms
13  l3-peer.tlot02.pr.telstraglobal.net (134.159.62.14)  180.320 ms
    8-3-2.edge1.losangels.level3.net (4.68.70.69)  175.597 ms
    xe-11-2-0.edge1.losangeles6.level3.net (4.68.62.9)  175.657 ms
14  vlan80.csw3.losangeles1.level3.net (4.69.144.190)  180.162 ms
    vlan90.csw4.losangeles1.level3.net (4.69.144.254)  191.040 ms
    vlan70.csw2.losangeles1.level3.net (4.69.144.126)  184.578 ms
15  ae-83-83.ebr3.losangeles1.level3.net (4.69.137.41)  182.365 ms
    ae-73-73.ebr3.losangeles1.level3.net (4.69.137.37)  178.026 ms
    ae-83-83.ebr3.losangeles1.level3.net (4.69.137.41)  179.989 ms
16  4.69.132.82 (4.69.132.82)  240.228 ms  256.993 ms  248.861 ms
17  ae-61-61.csw1.washington1.level3.net (4.69.134.130)  250.033 ms
    ae-71-71.csw2.washington1.level3.net (4.69.134.134)  242.276 ms
    ae-61-61.csw1.washington1.level3.net (4.69.134.130)  241.633 ms
18  ae-62-62.ebr2.washington1.level3.net (4.69.134.145)  237.337 ms
    ae-82-82.ebr2.washington1.level3.net (4.69.134.153)  246.813 ms  257.720 ms
19  ae-42-42.ebr2.paris1.level3.net (4.69.137.53)  317.737 ms
    ae-44-44.ebr2.paris1.level3.net (4.69.137.61)  324.537 ms
    ae-42-42.ebr2.paris1.level3.net (4.69.137.53)  324.442 ms
20  ae-46-46.ebr1.frankfurt1.level3.net (4.69.143.137)  355.799 ms  352.329 ms
    ae-48-48.ebr1.frankfurt1.level3.net (4.69.143.145)  367.976 ms
21  ae-61-61.csw1.frankfurt1.level3.net (4.69.140.2)  368.969 ms
    ae-81-81.csw3.frankfurt1.level3.net (4.69.140.10)  361.555 ms
    ae-61-61.csw1.frankfurt1.level3.net (4.69.140.2)  367.563 ms
22  ae-3-80.edge7.frankfurt1.level3.net (4.69.154.139)  352.131 ms
    ae-1-60.edge7.frankfurt1.level3.net (4.69.154.11)  369.579 ms  374.867 ms
23  as33891-net.edge7.frankfurt1.level3.net (195.16.162.94)  400.831 ms  368.776 ms  372.726 ms
24  hos-bb1.juniper1.rz16.hetzner.de (213.239.240.199)  360.924 ms
    hos-bb1.juniper2.rz16.hetzner.de (213.239.240.200)  358.296 ms  359.878 ms
25  hos-tr4.ex3k1.rz16.hetzner.de (213.239.223.226)  361.229 ms
    hos-tr2.ex3k1.rz16.hetzner.de (213.239.222.98)  369.616 ms
    hos-tr4.ex3k1.rz16.hetzner.de (213.239.223.226)  359.909 ms
26  cjw.dyndns.biz (176.9.140.228)  369.865 ms  359.223 ms  2305.881 ms

*/

        def results = [
                [host: "10.205.64.1", ip: "10.205.64.1", pings: [8.866, 11.384, 19.244]],
                [host: "58.160.16.198", ip: "58.160.16.198", pings: [20.945, 9.549, 19.012]],
                [host: "58.160.23.226", ip: "58.160.23.226", pings: [12.195, 8.418, 7.627]],
                [host: "172.18.241.105", ip: "172.18.241.105", pings: [10.470, 10.361, 12.044]],
                [host: "bundle-ether3.woo-core1.brisbane.telstra.net", ip: "203.50.11.52", pings: [14.680, 11.657, 11.963]],
                [host: "tengige0-8-0-5-1.cha-core4.brisbane.telstra.net", ip: "203.50.6.217", pings: [11.228, 16.290, 8.903]],
                [host: "bundle-ether11.ken-core4.sydney.telstra.net", ip: "203.50.11.72", pings: [28.911, 37.600, 35.883]],
                [host: "bundle-ether1.pad-gw2.sydney.telstra.net", ip: "203.50.6.29", pings: [25.792, 26.018, 35.662]],
                [host: "tengige10-0-0.sydp-core02.sydney.reach.com", ip: "203.50.13.94", pings: [23.927, 33.636, 24.025]],
                [host: "i-0-0-2-0.tlot-core01.bx.telstraglobal.net", ip: "202.84.140.78", pings: [184.158, 185.224, 184.806]],
                [host: "i-0-4-0-4.tlot02.bi.telstraglobal.net", ip: "202.40.149.166", pings: [179.562, 182.883, 181.214]],
                [host: "l3-peer.tlot02.pr.telstraglobal.net", ip: "134.159.62.14", pings: [180.320]],
                [host: "8-3-2.edge1.losangels.level3.net", ip: "4.68.70.69", pings: [175.597]],
                [host: "xe-11-2-0.edge1.losangeles6.level3.net", ip: "4.68.62.9", pings: [175.657]],
                [host: "vlan80.csw3.losangeles1.level3.net", ip: "4.69.144.190", pings: [180.162]],
                [host: "vlan90.csw4.losangeles1.level3.net", ip: "4.69.144.254", pings: [191.040]],
                [host: "vlan70.csw2.losangeles1.level3.net", ip: "4.69.144.126", pings: [184.578]],
                [host: "ae-83-83.ebr3.losangeles1.level3.net", ip: "4.69.137.41", pings: [182.365]],
                [host: "ae-73-73.ebr3.losangeles1.level3.net", ip: "4.69.137.37", pings: [178.026]],
                [host: "ae-83-83.ebr3.losangeles1.level3.net", ip: "4.69.137.41", pings: [179.989]],
                [host: "4.69.132.82", ip: "4.69.132.82", pings: [240.228, 256.993, 248.861]],
                [host: "ae-61-61.csw1.washington1.level3.net", ip: "4.69.134.130", pings: [250.033]],
                [host: "ae-71-71.csw2.washington1.level3.net", ip: "4.69.134.134", pings: [242.276]],
                [host: "ae-61-61.csw1.washington1.level3.net", ip: "4.69.134.130", pings: [241.633]],
                [host: "ae-62-62.ebr2.washington1.level3.net", ip: "4.69.134.145", pings: [237.337]],
                [host: "ae-82-82.ebr2.washington1.level3.net", ip: "4.69.134.153", pings: [246.813, 257.720]],
                [host: "ae-42-42.ebr2.paris1.level3.net", ip: "4.69.137.53", pings: [317.737]],
                [host: "ae-44-44.ebr2.paris1.level3.net", ip: "4.69.137.61", pings: [324.537]],
                [host: "ae-42-42.ebr2.paris1.level3.net", ip: "4.69.137.53", pings: [324.442]],
                [host: "ae-46-46.ebr1.frankfurt1.level3.net", ip: "4.69.143.137", pings: [355.799, 352.329]],
                [host: "ae-48-48.ebr1.frankfurt1.level3.net", ip: "4.69.143.145", pings: [367.976]],
                [host: "ae-61-61.csw1.frankfurt1.level3.net", ip: "4.69.140.2", pings: [368.969]],
                [host: "ae-81-81.csw3.frankfurt1.level3.net", ip: "4.69.140.10", pings: [361.555]],
                [host: "ae-61-61.csw1.frankfurt1.level3.net", ip: "4.69.140.2", pings: [367.563]],
                [host: "ae-3-80.edge7.frankfurt1.level3.net", ip: "4.69.154.139", pings: [352.131]],
                [host: "ae-1-60.edge7.frankfurt1.level3.net", ip: "4.69.154.11", pings: [369.579, 374.867]],
                [host: "as33891-net.edge7.frankfurt1.level3.net", ip: "195.16.162.94", pings: [400.831, 368.776, 372.726]],
                [host: "hos-bb1.juniper1.rz16.hetzner.de", ip: "213.239.240.199", pings: [360.924]],
                [host: "hos-bb1.juniper2.rz16.hetzner.de", ip: "213.239.240.200", pings: [358.296, 359.878]],
                [host: "hos-tr4.ex3k1.rz16.hetzner.de", ip: "213.239.223.226", pings: [361.229]],
                [host: "hos-tr2.ex3k1.rz16.hetzner.de", ip: "213.239.222.98", pings: [369.616]],
                [host: "hos-tr4.ex3k1.rz16.hetzner.de", ip: "213.239.223.226", pings: [359.909]],
                [host: "cjw.dyndns.biz", ip: "176.9.140.228", pings: [369.865, 359.223, 2305.881]],
        ]

        results.each {
            def delay = Math.round(it.pings.sum() + 1000 * (3 - it.pings.size()))
            println "delaying for ${delay} ms"
            Thread.sleep(delay)
            closure.call(it)
        }

        return results
    }
}
