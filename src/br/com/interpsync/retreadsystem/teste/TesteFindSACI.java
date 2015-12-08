/*  1:   */ package br.com.interpsync.retreadsystem.teste;
/*  2:   */ 
/*  3:   */ import java.io.PrintStream;
/*  4:   */ import java.text.SimpleDateFormat;
/*  5:   */ import java.util.Date;
/*  6:   */ 
/*  7:   */ public class TesteFindSACI
/*  8:   */ {
/*  9:   */   public static void main(String[] args)
/* 10:   */   {
/* 11:16 */     SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
/* 12:17 */     sdf.format(new Date(System.currentTimeMillis()));
/* 13:18 */     String datahj = sdf.format(new Date(System.currentTimeMillis()));
/* 14:19 */     System.out.println("Data: " + datahj);
/* 15:   */   }
/* 16:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.teste.TesteFindSACI
 * JD-Core Version:    0.7.0.1
 */