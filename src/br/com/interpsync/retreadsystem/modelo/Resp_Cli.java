/*  1:   */ package br.com.interpsync.retreadsystem.modelo;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Resp_Cli
/*  6:   */ {
/*  7:   */   private String CNPJCPF;
/*  8:   */   private BigDecimal RespVencidas;
/*  9:   */   private BigDecimal RespAVencer;
/* 10:   */   private int StEI;
/* 11:   */   
/* 12:   */   public String getCNPJCPF()
/* 13:   */   {
/* 14:20 */     return this.CNPJCPF;
/* 15:   */   }
/* 16:   */   
/* 17:   */   public void setCNPJCPF(String CNPJCPF)
/* 18:   */   {
/* 19:24 */     this.CNPJCPF = CNPJCPF;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public BigDecimal getRespVencidas()
/* 23:   */   {
/* 24:28 */     return this.RespVencidas;
/* 25:   */   }
/* 26:   */   
/* 27:   */   public void setRespVencidas(BigDecimal RespVencidas)
/* 28:   */   {
/* 29:32 */     this.RespVencidas = RespVencidas;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public BigDecimal getRespAVencer()
/* 33:   */   {
/* 34:36 */     return this.RespAVencer;
/* 35:   */   }
/* 36:   */   
/* 37:   */   public void setRespAVencer(BigDecimal RespAVencer)
/* 38:   */   {
/* 39:40 */     this.RespAVencer = RespAVencer;
/* 40:   */   }
/* 41:   */   
/* 42:   */   public int getStEI()
/* 43:   */   {
/* 44:44 */     return this.StEI;
/* 45:   */   }
/* 46:   */   
/* 47:   */   public void setStEI(int StEI)
/* 48:   */   {
/* 49:48 */     this.StEI = StEI;
/* 50:   */   }
/* 51:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.modelo.Resp_Cli
 * JD-Core Version:    0.7.0.1
 */