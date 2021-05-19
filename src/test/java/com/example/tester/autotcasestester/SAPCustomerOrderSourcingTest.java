package com.example.tester.autotcasestester;


import org.junit.Test;

import org.hamcrest.Matcher;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SAPCustomerOrderSourcingTest {

    @Test
    public void getAttributes_ExtensionTypeDefined_Is_Yes() {
        given()
            .queryParam( "size", "1")
            .queryParam( "extensionType", "SOURCE")
            .queryParam( "page", "0")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            .statusCode( isSuccess())
            ;
    }

    @Test
    public void getAttributes_ExtensionTypeDefined_Is_No() {
        given()
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            .statusCode( isSuccess())
            ;
    }

    @Test
    public void getAttributes_PageValue_Is_Gt_0() {
        given()
            .queryParam( "size", "100")
            .queryParam( "extensionType", "SOURCE")
            .queryParam( "page", "221957529")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            .statusCode( isSuccess())
            ;
    }

    @Test
    public void getAttributes_ExtensionTypeType_Is_Null() {
        given()
            .queryParam( "extensionType", "")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            // extensionType.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributes_ExtensionTypeValue_Is_Other() {
        given()
            .queryParam( "extensionType", "}Rb*~DG<zXw.Uwh_ {cqYr/}&gB^fO %No_$)VdEn)S+GUAR?TRCHk'A:z2B&nGlU@}4Tc1iiDd<fu_/k`vI`[7BKfe,Q]~^U XLZt<dD):>})&GE#\"KfDrV?^..J7j/xWSTJZ-<E>d#~LNcwwo")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            // extensionType.Value=Other
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributes_PageType_Is_Null() {
        given()
            .queryParam( "page", "")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            // page.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributes_PageType_Is_NotInteger() {
        given()
            .queryParam( "page", "")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            // page.Type=Not integer
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributes_PageValue_Is_M1() {
        given()
            .queryParam( "page", "-1")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            // page.Value.Is=-1
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributes_SizeType_Is_Null() {
        given()
            .queryParam( "size", "")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            // size.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributes_SizeType_Is_NotInteger() {
        given()
            .queryParam( "size", "852.2")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            // size.Type=Not integer
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributes_SizeValue_Is_0() {
        given()
            .queryParam( "size", "0")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            // size.Value.Is=0
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributes_SizeValue_Is_101() {
        given()
            .queryParam( "size", "101")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/")
        .then()
            // size.Value.Is=101
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyDefined_Is_Yes() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"cV\",\"defaultValue\":{\"ukr\":-472.0,\"phirkpdtcc\":\",M<`{k=\",\"puezzitfvvxx\":\"3)o?q>\\\\\"},\"extensionType\":\"SOURCE\",\"name\":\"e\",\"description\":\"p\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            .statusCode( isSuccess())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesExtensionTypeValue_Is_SOURCING() {
        given()
            .contentType( "application/json")
            .request().body( "{\"defaultValue\":{},\"extensionType\":\"SOURCING\",\"name\":\"LRaHVmWYdYIoHB0zu84psIlitipL4mia_tFDc8xqESyZpPovE1\",\"type\":\"DOUBLE\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            .statusCode( isSuccess())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesDescriptionValueLength_Is_1024() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"JoI\",\"defaultValue\":{\"miqzbwospukb\":1021.3,\"uzemccuw\":499},\"extensionType\":\"SOURCE\",\"name\":\"W\",\"description\":\"p0: ﻿    _\\n37{   1 　  6 16:\\t7　\\r\\u000b   \\f2 8_{ +  6﻿.0-.\\r  _-p 7-\\t  . - 8L  +020-\\t: L ;7 1\\u000b\\r{9 -3 ﻿  \\f\\n6+　198  .5 -1  2}   {;\\n\\n;-　 \\r3  - \\n 93p95;:  __ 6\\f 3  -\\f  63   .  9 1 \\r \\f:66 L ; 2-}   {　   \\n4\\t2 \\u000b  :51.4_4\\n 5   }3  2 4 _  　 _ ﻿L   {5  _\\f L1\\f{   --6  1  +2\\f \\n   \\n    p    L: +\\t\\f2 8:0.- \\t 5 }　  11  } } 8 {p  9  p L  \\fL\\t   p1-  p}　 }3 ﻿   \\f\\n   0﻿2 \\r -_ :01_  8　;;7.  + 8  \\u000b 06 \\n\\r. p﻿ \\f{ 61 　7 ﻿} 1 \\u000bLL5\\f205  \\n02_ . 7 ﻿ :\\u000b.   +  　3  8  -  \\n\\r 8  17-:\\n 1　 :\\n   \\r9　7p-582p  31 90\\u000b-﻿;1 ﻿_53 5 { 9\\r {-4 :  0Lp﻿L}p-\\f} 5  -\\n\\r　-  \\t; L+:　\\n    \\f 6 ; -\\n  0 1_ \\n 　 {37p21  \\u000b: 5_ 2   　 0      8\\t5 75\\t   }}:.  01\\t 　94\\n1}  _71L6   　 4..1  5 { 0 _   p 8 55﻿03\\u000b5..\\n\\t ;{ p 0 5   64:  p\\u000b.\\u000b0 05\\r1 563. : \\n 14.7p9   4 } \\f; 3 - _\\r2.　   6_　 \\u000b5L\\t2   7 6 ﻿097 　\\t  　_ _ \\u000b : 16  \\u000b\\t42}﻿;\\r\\u000b: 2\\f 5     L_ ﻿:;\\r\\r{\\u000b \\u000b548.     \\r    \\f;}   6　6 :  ;\\r 0.   : _ 5 82;:L \\u000b\\f }L; 2 \\tL﻿86 \\u000b  0 L   \\u000b\\r1﻿ 　6 L \\u000b ﻿ .. \\f\\n 5 1L 08 ;5﻿ _ :﻿2     .  L 8 7      :3 -68{ p5\\t4\\t8{ L   }     71.  -﻿{  \\f ;　+0\\t \\n677;}   ﻿  19\\r:\\t  3.\\f-\\r  \\u000b \\t 6 1 28\\t ﻿7 0 7\\u000b   8　     \\f8{ ﻿ \\u000b9.  4 \\u000b 9p\",\"type\":\"INTEGER\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            .statusCode( isSuccess())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesTypeValue_Is_BOOLEAN() {
        given()
            .contentType( "application/json")
            .request().body( "{\"defaultValue\":{},\"extensionType\":\"SOURCING\",\"name\":\"ol3J3mvMcdiRkn56kJQ0xYrMA0N-IAMhF3l8k2qlsY36_ZUzzE\",\"type\":\"BOOLEAN\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            .statusCode( isSuccess())
            ;
    }

    @Test
    public void postAttributes_BodyDefined_Is_No() {
        given()
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.Defined=No
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyMediaType_Is_Other() {
        given()
            .contentType( "text/plain")
            .request().body( "[\"jA6\",\"JL6IJ\",\"t')3y\"]")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.Media-Type=Other
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonType_Is_Null() {
        given()
            .contentType( "application/json")
            .request().body( "null")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonType_Is_NotObject() {
        given()
            .contentType( "application/json")
            .request().body( "-273.6")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Type=Not object
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesExtensionTypeDefined_Is_No() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"lA\",\"defaultValue\":{\"viojichdlsy\":[\"s[w_I\",\"G\"],\"phhiahmuffmsytov\":true},\"name\":\"j\",\"description\":\"}\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.extensionType.Defined=No
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesExtensionTypeType_Is_Null() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"yj\",\"defaultValue\":{\"nijhbomfqylr\":-586},\"extensionType\":null,\"name\":\"U\",\"description\":\"{\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.extensionType.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesExtensionTypeType_Is_NotString() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"v2\",\"defaultValue\":{\"oynco\":true,\"h\":true},\"extensionType\":[],\"name\":\"D\",\"description\":\"p\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.extensionType.Type=Not string
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesExtensionTypeValue_Is_Other() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"yy\",\"defaultValue\":{\"tvhkzkorwvrna\":[\"B\"],\"hijrmdpxbjemlw\":{\"yeghq\":true,\"xpsqtptjihm\":\"^)+?I5S\",\"prxoxhlytklap\":true},\"bjwvzvhegndq\":175.8},\"extensionType\":\"u~qZiH+#YD-]S\\\"n&_+@qx$1e !BzQ?ow*lp2=%/te/|pSjuCf`)j&XuR)U0t$U\\\\p3xb\\\"m\\\"I@dW1O,_?y1,c UI1E^bsv% ->\\\\]Z4YUsW,_s(_nV`$6(_Gk2IK$!sa)?I^A?&?yK\\\\>>oxwse)c?(|MQXK+fAdB?)5{'M&~+UL\\\"*V@WR@z'|}m?wj_\",\"name\":\"Q\",\"description\":\"4\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.extensionType.Value=Other
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesNameDefined_Is_No() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"fB\",\"defaultValue\":{\"qgmzidzwc\":-748.4,\"bp\":{\"fhdcikkqxqtsczek\":-66},\"npmthkbyrovcjgdh\":\"[\"},\"extensionType\":\"SOURCE\",\"description\":\"9\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.name.Defined=No
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesNameType_Is_Null() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"7W\",\"defaultValue\":{\"aylqrxara\":true},\"extensionType\":\"SOURCE\",\"name\":null,\"description\":\"7\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.name.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesNameType_Is_NotString() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"02\",\"defaultValue\":{\"dkyordnzyytlfadq\":[\"~d[B@o\"]},\"extensionType\":\"SOURCE\",\"name\":508,\"description\":\"7\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.name.Type=Not string
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesNameValueLength_Is_0() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"Qk\",\"defaultValue\":{\"jqtbbr\":805},\"extensionType\":\"SOURCE\",\"name\":\"\",\"description\":\"7\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.name.Value.Length=0
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesNameValueLength_Is_51() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"3Q\",\"defaultValue\":{\"chufswgyvvvcbm\":true,\"tzxsqto\":-487.1},\"extensionType\":\"SOURCE\",\"name\":\"8]]3bPxVp\\\\N|H.#_ WvOfyC*-CjXr5\\\"-`1c >Ljla'Mo3Im,s3/\",\"description\":\"p\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.name.Value.Length=51
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesNameValueMatchesPattern_Is_No() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"SO\",\"defaultValue\":{\"uyhiscrnighkqdr\":107,\"vebtomgp\":-837},\"extensionType\":\"SOURCE\",\"name\":\"1\",\"description\":\"5\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.name.Value.Matches-Pattern=No
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesDescriptionType_Is_Null() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"og\",\"defaultValue\":{\"apfvajovofxvwm\":true},\"extensionType\":\"SOURCE\",\"name\":\"p\",\"description\":null,\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.description.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesDescriptionType_Is_NotString() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"pI\",\"defaultValue\":{\"npwdqwzzbrjryzh\":184,\"ags\":[\"|HF\"],\"cakfhfbypqqu\":[\"<\"]},\"extensionType\":\"SOURCE\",\"name\":\"o\",\"description\":true,\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.description.Type=Not string
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesDescriptionValueLength_Is_0() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"rG\",\"defaultValue\":{\"nvfdcdyili\":\"`Lg\",\"igtglesrofzs\":true},\"extensionType\":\"SOURCE\",\"name\":\"K\",\"description\":\"\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.description.Value.Length=0
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesDescriptionValueLength_Is_1025() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"F6\",\"defaultValue\":{\"mw\":[],\"aysekbalwv\":-112},\"extensionType\":\"SOURCE\",\"name\":\"O\",\"description\":\"p2u$Eo%x2~H:)51OSbpASP,@YLv*F42.,=3,]ohJ3@&^a7kaAQ.xkU<KBPS|rT f+8*_<x]/Rq0id|@0f\\\\-k_.;G-H)hc5\\\\xEzX51ayT><7|!q$^xNVjX-J,%]Hkmb&:o+aG-n<ENnL-AINn0ht>+}8A;Ns8u}8h~&K46ucy&K{fCwy%fm@w|J$)ym|_$eQ-^{NNUzlz{V#Lg^oEiC~ /'FEI?2^l) CGXr'Qa+^8mwuux1uK<0mp$N)g{aCHPfn-1JH3ja\\\\g)p]Mxy6UFvrGd<wj8@QCHUpB}nM~dNJ]#Gz3$ZLzYo')SsVlsNy-&^#yrJ81]>T,H5H2oH,Ttsa|x&#8o-aSl-a9WRgyoeUZ7x;0w3hI\\\\[v:,h}>$(({$ Lj+%A85pw$OQm[MEB4{U2@1<LfV{l*?;\\\\F`Og>Ke0xb(1;'{\\\\Q?^@a$R\\\\o(Yv5+Fgums/ey]<3@`g@t\\\\yty}/tT UL5AT'h#+*28;0_Cj$pbMquUyi\\\\h0K__J4|Iun&{ORGkL#uspSMUr;1\\\\BhcRDHZ _W|Syk=>ZFP NTC\\\"1/bH-ndD*0q@d3<N?G#4qeU}q'KrgIiG(z`pl&%2I`9D+%FC\\\\86ar0SWlEQwpL_9'$6\\\"KHB\\\"hC}i=\\\\} X\\\"Y?i<p),nS,ukBf_D_|8yNuFnx:N;b@lU0ht\\\"cY,kr*sFV ql6[,`R_p[bbH]W+XPY?#A A[kNm{xrbfkPU$[#C,vv![PB/p2:@FsxpVcfViPzLb#D_x>#!\\\\G*$fD2*\\\\Ghxg zl}w\\\"eXwq[|xq_Qge+ @>#E==]Bn/+^x8OfOB[\\\\f^uTzOD.zbITv7fj%h.OsI{a?O=E;~&*k?TWglt-0|DYs6C(l8N1<_sl+<T*.I;M_'-\\\"?(G+Mh Q8H/J6wD<ARnuZgSR|s/LTv(sgK,B|uDkH%Zh04/FQDe4kj,dd&:( Sgi%&hkWaL;C$L3<({uvox.>R,.`Hsm-M'gjT~j7qc+/:L<[h{D,tcr2Y:`5atJr^)sIxmvvwfHbRS}4vO4,Eo09D@W,\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.description.Value.Length=1025
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesDescriptionValueMatchesPattern_Is_No() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"kT\",\"defaultValue\":{\"fg\":true},\"extensionType\":\"SOURCE\",\"name\":\"t\",\"description\":\"'\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.description.Value.Matches-Pattern=No
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesTypeDefined_Is_No() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"HV\",\"defaultValue\":{\"zsyhg\":{}},\"extensionType\":\"SOURCE\",\"name\":\"J\",\"description\":\"6\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.type.Defined=No
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesTypeType_Is_Null() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"qt\",\"defaultValue\":{\"kpjufsrntf\":true,\"uhcrxrvctupju\":304.4,\"timtepecobk\":[\"1va*\\\\1\",\"Ji0a[y\",\")wOn&P\"]},\"extensionType\":\"SOURCE\",\"name\":\"T\",\"description\":\"9\",\"type\":null}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.type.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesTypeType_Is_NotString() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"Z7\",\"defaultValue\":{\"pfvkjfqhzjnoav\":\"J\"},\"extensionType\":\"SOURCE\",\"name\":\"S\",\"description\":\"6\",\"type\":true}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.type.Type=Not string
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesTypeValue_Is_Other() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"eH\",\"defaultValue\":{\"dhxmxwetlojrx\":840.1},\"extensionType\":\"SOURCE\",\"name\":\"m\",\"description\":\"_\",\"type\":\"ZToHt&r.=-QyE(yHs{0!^H-J@m'G%1m^u 2<&9~0HqvdqM~G@G1S_[^#WiRiM%@.@E|zvI}#nE]{BB#%=K/'?sYIT@N2MuJ3F%-g<=[IX0E|:8$}RQB2k.zAH6`btXg'!azzCjp(VP$t\\\"?xv 1nJJe3AJErtBn2mjFN{m^4`qfW !U8.'.dwVf'CVK|+P{R_)/Cp(RQ}l@\\\\*P\\\\ZD;-FDp]#o{6G<'\\\"Z\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.type.Value=Other
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesDefaultValueDefined_Is_No() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"xW\",\"extensionType\":\"SOURCE\",\"name\":\"W\",\"description\":\"+\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.defaultValue.Defined=No
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesDefaultValueType_Is_Null() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"Gj\",\"defaultValue\":null,\"extensionType\":\"SOURCE\",\"name\":\"l\",\"description\":\"_\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.defaultValue.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesDefaultValueType_Is_NotObject() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"LU\",\"defaultValue\":true,\"extensionType\":\"SOURCE\",\"name\":\"m\",\"description\":\"4\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.defaultValue.Type=Not object
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesUnitType_Is_Null() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":null,\"defaultValue\":{\"sxkwcmmq\":\"%lW}\",\"nwyh\":true,\"jveegwzfsryrkj\":-1.8},\"extensionType\":\"SOURCE\",\"name\":\"i\",\"description\":\"3\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.unit.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesUnitType_Is_NotString() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":{},\"defaultValue\":{\"xs\":936.4},\"extensionType\":\"SOURCE\",\"name\":\"a\",\"description\":\"{\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.unit.Type=Not string
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesUnitValueLength_Is_1() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"}\",\"defaultValue\":{\"irqwq\":[\"8HvO_\"],\"dsmwmy\":[\")\",\";e^W(8\",\"\"]},\"extensionType\":\"SOURCE\",\"name\":\"K\",\"description\":\"p\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.unit.Value.Length=1
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesUnitValueLength_Is_4() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"U[@N\",\"defaultValue\":{\"vfhyblqfta\":[\"XO\",\"oK_`sAf/\"],\"ypld\":[\"X*KS\"],\"oafjzm\":[\"qB&h[m.\",\"6\\\"N?\",\"O%N\"]},\"extensionType\":\"SOURCE\",\"name\":\"g\",\"description\":\"8\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.unit.Value.Length=4
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesUnitValueMatchesPattern_Is_No() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"<*\",\"defaultValue\":{\"h\":\"R|6}LUR\",\"pxrcskyhypr\":911},\"extensionType\":\"SOURCE\",\"name\":\"n\",\"description\":\"L\",\"type\":\"STRING\"}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.unit.Value.Matches-Pattern=No
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void postAttributes_BodyApplicationJsonValuePropertiesAdditional_Is_Yes() {
        given()
            .contentType( "application/json")
            .request().body( "{\"unit\":\"nR\",\"defaultValue\":{\"iprqno\":true,\"ghziyuirzgpsfjk\":\",}p?2)\"},\"extensionType\":\"SOURCE\",\"name\":\"l\",\"description\":\"1\",\"type\":\"STRING\",\"jafyzkjdfbd\":[\"Mj=[Tnwo\"]}")
        .when()
            .request( "POST", "http://localhost:12345/v1/attributes/")
        .then()
            // Body.application-json.Value.Properties.Additional=Yes
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void deleteAttributesId_IdDefined_Is_Yes() {
        given()
            .pathParam( "id", "78eD4bf5-789E-E2ec-C01c-50d7FeC52dCe")
        .when()
            .request( "DELETE", "http://localhost:12345/v1/attributes/{id}")
        .then()
            .statusCode( isSuccess())
            ;
    }

    @Test
    public void deleteAttributesId_IdType_Is_Null() {
        given()
            .pathParam( "id", "")
        .when()
            .request( "DELETE", "http://localhost:12345/v1/attributes/{id}")
        .then()
            // id.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void deleteAttributesId_IdValueLength_Is_35() {
        given()
            .pathParam( "id", "jLN2{L6wKJ1[BL8hdyoJ*j,0g}XqO':^h\\$")
        .when()
            .request( "DELETE", "http://localhost:12345/v1/attributes/{id}")
        .then()
            // id.Value.Length=35
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void deleteAttributesId_IdValueLength_Is_37() {
        given()
            .pathParam( "id", "EUQHD_2nu+SG<z2EzJV<C?(ZxeWW}k#='b@E2")
        .when()
            .request( "DELETE", "http://localhost:12345/v1/attributes/{id}")
        .then()
            // id.Value.Length=37
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void deleteAttributesId_IdValueMatchesPattern_Is_No() {
        given()
            .pathParam( "id", "cs!PXR<O1Y,6Xg[BPYm%g@:}w1xm)`yLO5]3")
        .when()
            .request( "DELETE", "http://localhost:12345/v1/attributes/{id}")
        .then()
            // id.Value.Matches-Pattern=No
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributesId_IdDefined_Is_Yes() {
        given()
            .pathParam( "id", "71eb01EB-eF2F-9ecC-a45d-207Ed06f1fe5")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/{id}")
        .then()
            .statusCode( isSuccess())
            ;
    }

    @Test
    public void getAttributesId_IdType_Is_Null() {
        given()
            .pathParam( "id", "")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/{id}")
        .then()
            // id.Type=null
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributesId_IdValueLength_Is_35() {
        given()
            .pathParam( "id", "JgyG1~#'' D&NB!-gGJv9!&7?.WxwhuVx[T")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/{id}")
        .then()
            // id.Value.Length=35
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributesId_IdValueLength_Is_37() {
        given()
            .pathParam( "id", "q,y1Gv+@QH8WKZiTE6@Uc].oM/j2{Aa'l-aA*")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/{id}")
        .then()
            // id.Value.Length=37
            .statusCode( isBadRequest())
            ;
    }

    @Test
    public void getAttributesId_IdValueMatchesPattern_Is_No() {
        given()
            .pathParam( "id", "z/]t7ZMHZ2CZf;Xx(\"'DNAM}@9v)(R^c>u\"s")
        .when()
            .request( "GET", "http://localhost:12345/v1/attributes/{id}")
        .then()
            // id.Value.Matches-Pattern=No
            .statusCode( isBadRequest())
            ;
    }

    private Matcher<Integer> isSuccess() {
        return allOf( greaterThanOrEqualTo(200), lessThan(300));
    }

    private Matcher<Integer> isBadRequest() {
        return allOf( greaterThanOrEqualTo(400), lessThan(500));
    }
}
