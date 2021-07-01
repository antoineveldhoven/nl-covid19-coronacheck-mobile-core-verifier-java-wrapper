/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.invitado.covidqrcheck;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import java.io.UnsupportedEncodingException;

public class CheckCode {
    public static void main(String[] args) throws UnsupportedEncodingException{
        CovidLib covidLib = (CovidLib) Native.loadLibrary(
            "covid", CovidLib.class);

        byte[] code = "F.BSBJR4KCVU8749*747OWT4-608SDA%BKSK0/WKBGB-3T*723%GE/$3$:$A*Z12J7GXWZNOC+EKE249O-C0T0+1V1BMK0MII1PFB470G*JV0V02VCGV+T-J8 1AQEONSHP YFHCPXKYTUMT9CH*YE 8*OB4DWNRSK MOFDCQIUN1*ORSMJU:J36 $898G5  UO8YZV*P0C-$S+AA*XLCA57EAW%QX0CZQT%ORZ4$8/ATXZO7XR-KZ*RMXG.VSCKEG02XKHDL0$EQZ.E4E/WQK$*K+L3964Q+X-SACGCMI2853$ BHS3JTF77Q$%A78G:G-80U$N1YFD2P.19AGPMFHG3XN.%3$C-0:+ AV21*QFG7/SGXYXB F.$%/0PGD.IEYG*98I4O8CZ0E-POG1EFCTYPMX+RR208YKK*X+MDISKF:*-NTUQV24HQ81OJ6JWR09QX/JYM0%RYW/1Y3KV%5J4+T%Z0S-KZI1U IGEW3B$MIPDRJ74+%+:ORP2SVJYK9Q87V-2UQ5ELGJ9E*+IA-%4VTI7FFC6N+%KPINUAH3+35MY*-VLOO:390*UZCC:.U A%GC%CQE%VX-NN*B2AJO*3.A:19B9O5 YZ7$57F39F%4REO/3OBZ7/EXD7C1IKC*I0$1%HG9G938S*0J2A/-ST2H9:DSN4NN1+NJ3.7XWAQ%I%NXCPJ$BR51893EG:M6  T8BROIG/N147$AVK2YNR$Q+2D.P*VRM8 U1I-7JG$ZB+P7$8MS5DCA4QYYOPF+-6$K65WR2%ELFMJRR155$-U$ZX/BGP3VB*P3HGFIAG9UYNNCFXJJM%AQHI*7820-M%738$JZL$V$P0%UO6UC/DMEHPD1W5Y9SXAX-.+2S4+LTT/E$E%A1CX 02N+4SH8P$V6G2.RCNW/93XT7NB19%%07V5B6CYZS8S6JKPQ5G0KJ/BC3L FT9CWY$6AM/ 9I/6GS5".getBytes("UTF8");
        
        Memory arr = new Memory(code.length * Native.getNativeSize(Byte.TYPE));
        arr.write(0, code, 0, code.length); 
        GoSlice.ByValue slice = new GoSlice.ByValue();
        slice.data = arr;
        slice.len = code.length;
        slice.cap = code.length;

        System.out.println(covidLib.CheckCode(slice));
    }
}
