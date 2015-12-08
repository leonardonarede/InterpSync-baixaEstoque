/*  1:   */ package br.com.interpsync.saci.teste;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import java.sql.SQLException;
/*  5:   */ import java.text.SimpleDateFormat;
/*  6:   */ import java.util.Date;
/*  7:   */ 
/*  8:   */ public class Testesaci
/*  9:   */ {
/* 10:   */   public static void main(String[] args)
/* 11:   */     throws SQLException, ClassNotFoundException, Exception
/* 12:   */   {
/* 13:17 */     Date datahj = new Date();
/* 14:   */     
/* 15:19 */     SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
/* 16:20 */     String dataf = df.format(datahj);
/* 17:21 */     System.out.println(dataf);
/* 18:   */   }
/* 19:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.saci.teste.Testesaci
 * JD-Core Version:    0.7.0.1
 */