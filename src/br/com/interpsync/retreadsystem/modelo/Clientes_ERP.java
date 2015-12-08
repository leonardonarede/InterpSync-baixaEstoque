/*   1:    */ package br.com.interpsync.retreadsystem.modelo;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ 
/*   5:    */ public class Clientes_ERP
/*   6:    */ {
/*   7:    */   private String CNPJCPF;
/*   8:    */   private String NomeCLI;
/*   9:    */   private String EndeCLI;
/*  10:    */   private String NrCLI;
/*  11:    */   private String BairroCLI;
/*  12:    */   private String CidadeCLI;
/*  13:    */   private String EstadoCLI;
/*  14:    */   private String CepCLI;
/*  15:    */   private String IERGCLI;
/*  16:    */   private String FJCLI;
/*  17:    */   private String VendR;
/*  18:    */   private String VendP;
/*  19:    */   private String VendS;
/*  20:    */   private String PrazoR;
/*  21:    */   private String PrazoP;
/*  22:    */   private String PrazoS;
/*  23:    */   private BigDecimal ComissaoNF;
/*  24:    */   private BigDecimal ComissaoTit;
/*  25:    */   private BigDecimal RespVencidas;
/*  26:    */   private BigDecimal RespAVencer;
/*  27:    */   private String CodConceito;
/*  28:    */   private String LimiteCrd;
/*  29:    */   private String NContato;
/*  30:    */   private String TContato;
/*  31:    */   private int StEI;
/*  32:    */   
/*  33:    */   public String getCNPJCPF()
/*  34:    */   {
/*  35: 41 */     return this.CNPJCPF;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setCNPJCPF(String CNPJCPF)
/*  39:    */   {
/*  40: 45 */     this.CNPJCPF = CNPJCPF;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public String getNomeCLI()
/*  44:    */   {
/*  45: 49 */     return this.NomeCLI;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public void setNomeCLI(String NomeCLI)
/*  49:    */   {
/*  50: 53 */     this.NomeCLI = NomeCLI;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public String getEndeCLI()
/*  54:    */   {
/*  55: 57 */     return this.EndeCLI;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public void setEndeCLI(String EndeCLI)
/*  59:    */   {
/*  60: 61 */     this.EndeCLI = EndeCLI;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public String getNrCLI()
/*  64:    */   {
/*  65: 65 */     return this.NrCLI;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setNrCLI(String NrCLI)
/*  69:    */   {
/*  70: 69 */     this.NrCLI = NrCLI;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public String getBairroCLI()
/*  74:    */   {
/*  75: 73 */     return this.BairroCLI;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setBairroCLI(String BairroCLI)
/*  79:    */   {
/*  80: 77 */     this.BairroCLI = BairroCLI;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getCidadeCLI()
/*  84:    */   {
/*  85: 81 */     return this.CidadeCLI;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setCidadeCLI(String CidadeCLI)
/*  89:    */   {
/*  90: 85 */     this.CidadeCLI = CidadeCLI;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public String getEstadoCLI()
/*  94:    */   {
/*  95: 89 */     return this.EstadoCLI;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setEstadoCLI(String EstadoCLI)
/*  99:    */   {
/* 100: 93 */     this.EstadoCLI = EstadoCLI;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getCepCLI()
/* 104:    */   {
/* 105: 97 */     return this.CepCLI;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setCepCLI(String CepCLI)
/* 109:    */   {
/* 110:101 */     this.CepCLI = CepCLI;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public String getIERGCLI()
/* 114:    */   {
/* 115:105 */     return this.IERGCLI;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setIERGCLI(String IERGCLI)
/* 119:    */   {
/* 120:109 */     this.IERGCLI = IERGCLI;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public String getFJCLI()
/* 124:    */   {
/* 125:113 */     return this.FJCLI;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setFJCLI(String FJCLI)
/* 129:    */   {
/* 130:117 */     this.FJCLI = FJCLI;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public String getVendR()
/* 134:    */   {
/* 135:121 */     return this.VendR;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setVendR(String VendR)
/* 139:    */   {
/* 140:125 */     this.VendR = VendR;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public String getVendP()
/* 144:    */   {
/* 145:129 */     return this.VendP;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setVendP(String VendP)
/* 149:    */   {
/* 150:133 */     this.VendP = VendP;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public String getVendS()
/* 154:    */   {
/* 155:137 */     return this.VendS;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setVendS(String VendS)
/* 159:    */   {
/* 160:141 */     this.VendS = VendS;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public String getPrazoR()
/* 164:    */   {
/* 165:145 */     return this.PrazoR;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setPrazoR(String PrazoR)
/* 169:    */   {
/* 170:149 */     this.PrazoR = PrazoR;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public String getPrazoP()
/* 174:    */   {
/* 175:153 */     return this.PrazoP;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setPrazoP(String PrazoP)
/* 179:    */   {
/* 180:157 */     this.PrazoP = PrazoP;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public String getPrazoS()
/* 184:    */   {
/* 185:161 */     return this.PrazoS;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void setPrazoS(String PrazoS)
/* 189:    */   {
/* 190:165 */     this.PrazoS = PrazoS;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public BigDecimal getComissaoNF()
/* 194:    */   {
/* 195:169 */     return this.ComissaoNF;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void setComissaoNF(BigDecimal ComissaoNF)
/* 199:    */   {
/* 200:173 */     this.ComissaoNF = ComissaoNF;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public BigDecimal getComissaoTit()
/* 204:    */   {
/* 205:177 */     return this.ComissaoTit;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public void setComissaoTit(BigDecimal ComissaoTit)
/* 209:    */   {
/* 210:181 */     this.ComissaoTit = ComissaoTit;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public BigDecimal getRespVencidas()
/* 214:    */   {
/* 215:186 */     return this.RespVencidas;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void setRespVencidas(BigDecimal RespVencidas)
/* 219:    */   {
/* 220:190 */     this.RespVencidas = RespVencidas;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public BigDecimal getRespAVencer()
/* 224:    */   {
/* 225:194 */     return this.RespAVencer;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public void setRespAVencer(BigDecimal RespAVencer)
/* 229:    */   {
/* 230:198 */     this.RespAVencer = RespAVencer;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public String getCodConceito()
/* 234:    */   {
/* 235:202 */     return this.CodConceito;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public void setCodConceito(String CodConceito)
/* 239:    */   {
/* 240:206 */     this.CodConceito = CodConceito;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public String getLimiteCrd()
/* 244:    */   {
/* 245:210 */     return this.LimiteCrd;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public void setLimiteCrd(String LimiteCrd)
/* 249:    */   {
/* 250:214 */     this.LimiteCrd = LimiteCrd;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public String getNContato()
/* 254:    */   {
/* 255:218 */     return this.NContato;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public void setNContato(String NContato)
/* 259:    */   {
/* 260:222 */     this.NContato = NContato;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public String getTContato()
/* 264:    */   {
/* 265:226 */     return this.TContato;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public void setTContato(String TContato)
/* 269:    */   {
/* 270:230 */     this.TContato = TContato;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public int getStEI()
/* 274:    */   {
/* 275:234 */     return this.StEI;
/* 276:    */   }
/* 277:    */   
/* 278:    */   public void setStEI(int StEI)
/* 279:    */   {
/* 280:238 */     this.StEI = StEI;
/* 281:    */   }
/* 282:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.modelo.Clientes_ERP
 * JD-Core Version:    0.7.0.1
 */