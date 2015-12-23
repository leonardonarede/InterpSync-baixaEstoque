/*  1:   */ package br.com.interpsync.retreadsystem.modelo;
/*  2:   */ 
/*  3:   */ import java.math.BigDecimal;
/*  4:   */ 
/*  5:   */ public class Osvr_ERP
/*  6:   */ {
/*  7:   */   private Integer NrOS;
/*  8:   */   private String TipoReg;
/*  9:   */   private String CodigoReg;
/* 10:   */   private BigDecimal Qtde;
/* 11:   */   private BigDecimal VrLiquido;
/* 12:   */   private BigDecimal VrBruto;
/* 13:   */   private String FilialTit;
/* 14:   */   private int statusERP;
/* 15:   */   private int OSVRID;

/* 16:   */   public Integer getNrOS()
/* 17:   */   {
/* 18:24 */     return this.NrOS;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public void setNrOS(Integer NrOS)
/* 22:   */   {
/* 23:28 */     this.NrOS = NrOS;
/* 24:   */   }
/* 25:   */   
/* 26:   */   public String getTipoReg()
/* 27:   */   {
/* 28:32 */     return this.TipoReg;
/* 29:   */   }
/* 30:   */   
/* 31:   */   public void setTipoReg(String TipoReg)
/* 32:   */   {
/* 33:36 */     this.TipoReg = TipoReg;
/* 34:   */   }
/* 35:   */   
/* 36:   */   public String getCodigoReg()
/* 37:   */   {
/* 38:40 */     return this.CodigoReg;
/* 39:   */   }
/* 40:   */   
/* 41:   */   public void setCodigoReg(String CodigoReg)
/* 42:   */   {
/* 43:44 */     this.CodigoReg = CodigoReg;
/* 44:   */   }
/* 45:   */   
/* 46:   */   public BigDecimal getQtde()
/* 47:   */   {
/* 48:48 */     return this.Qtde;
/* 49:   */   }
/* 50:   */   
/* 51:   */   public void setQtde(BigDecimal Qtde)
/* 52:   */   {
/* 53:52 */     this.Qtde = Qtde;
/* 54:   */   }
/* 55:   */   
/* 56:   */   public BigDecimal getVrLiquido()
/* 57:   */   {
/* 58:56 */     return this.VrLiquido;
/* 59:   */   }
/* 60:   */   
/* 61:   */   public void setVrLiquido(BigDecimal VrLiquido)
/* 62:   */   {
/* 63:60 */     this.VrLiquido = VrLiquido;
/* 64:   */   }
/* 65:   */   
/* 66:   */   public BigDecimal getVrBruto()
/* 67:   */   {
/* 68:64 */     return this.VrBruto;
/* 69:   */   }
/* 70:   */   
/* 71:   */   public void setVrBruto(BigDecimal VrBruto)
/* 72:   */   {
/* 73:68 */     this.VrBruto = VrBruto;
/* 74:   */   }
/* 75:   */   
/* 76:   */   public String getFilialTit()
/* 77:   */   {
/* 78:72 */     return this.FilialTit;
/* 79:   */   }
/* 80:   */   
/* 81:   */   public void setFilialTit(String FilialTit)
/* 82:   */   {
/* 83:76 */     this.FilialTit = FilialTit;
/* 84:   */   }
/* 85:   */   
/* 86:   */   public int getStatusERP()
/* 87:   */   {
/* 88:80 */     return this.statusERP;
/* 89:   */   }
/* 90:   */   
/* 91:   */   public void setStatusERP(int statusERP)
/* 92:   */   {
/* 93:84 */     this.statusERP = statusERP;
/* 94:   */   }


/* 95:   */

    public int getOSVRID() {
        return OSVRID;
    }

    public void setOSVRID(int OSVRID) {
        this.OSVRID = OSVRID;
    }
 }



/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar

 * Qualified Name:     br.com.interpsync.retreadsystem.modelo.Osvr_ERP

 * JD-Core Version:    0.7.0.1

 */