/*   1:    */ package br.com.interpsync.retreadsystem.modelo;
/*   2:    */ 
/*   3:    */ import java.math.BigDecimal;
/*   4:    */ import java.util.Date;
/*   5:    */ 
/*   6:    */ public class OS_ERP
/*   7:    */ {
/*   8:    */   private Integer NrOS;
/*   9:    */   private Integer NrLote;
/*  10:    */   private String ClienteID;
/*  11:    */   private String PneuID;
/*  12:    */   private String NrMatricula;
/*  13:    */   private String DotID;
/*  14:    */   private String MedidaID;
/*  15:    */   private String MarcaID;
/*  16:    */   private String ModeloID;
/*  17:    */   private String StatusID;
/*  18:    */   private String LRID;
/*  19:    */   private String VendedorID;
/*  20:    */   private String ColetadorID;
/*  21:    */   private String PrazoID;
/*  22:    */   private Date DtEmisID;
/*  23:    */   private Date DtprodID;
/*  24:    */   private Date DtPrefID;
/*  25:    */   private String SolicitadoID;
/*  26:    */   private Long OcorreuID;
/*  27:    */   private String MotivoID;
/*  28:    */   private String ERPID;
/*  29:    */   private BigDecimal ValorCarc;
/*  30:    */   private BigDecimal DescRef;
/*  31:    */   private BigDecimal DescRep;
/*  32:    */   private BigDecimal FatRef;
/*  33:    */   private BigDecimal FatRep;
/*  34:    */   private int StEI;
/*  35:    */   private BigDecimal VrCom;
/*  36:    */   private String LauFDC;
/*  37:    */   private String LauFFC;
/*  38:    */   private Integer StatusERP;
/*  39:    */   
/*  40:    */   public Integer getNrOS()
/*  41:    */   {
/*  42: 48 */     return this.NrOS;
/*  43:    */   }
/*  44:    */   
/*  45:    */   public void setNrOS(Integer NrOS)
/*  46:    */   {
/*  47: 52 */     this.NrOS = NrOS;
/*  48:    */   }
/*  49:    */   
/*  50:    */   public Integer getNrLote()
/*  51:    */   {
/*  52: 56 */     return this.NrLote;
/*  53:    */   }
/*  54:    */   
/*  55:    */   public void setNrLote(Integer NrLote)
/*  56:    */   {
/*  57: 60 */     this.NrLote = NrLote;
/*  58:    */   }
/*  59:    */   
/*  60:    */   public String getClienteID()
/*  61:    */   {
/*  62: 64 */     return this.ClienteID;
/*  63:    */   }
/*  64:    */   
/*  65:    */   public void setClienteID(String ClienteID)
/*  66:    */   {
/*  67: 68 */     this.ClienteID = ClienteID;
/*  68:    */   }
/*  69:    */   
/*  70:    */   public String getPneuID()
/*  71:    */   {
/*  72: 72 */     return this.PneuID;
/*  73:    */   }
/*  74:    */   
/*  75:    */   public void setPneuID(String PneuID)
/*  76:    */   {
/*  77: 76 */     this.PneuID = PneuID;
/*  78:    */   }
/*  79:    */   
/*  80:    */   public String getNrMatricula()
/*  81:    */   {
/*  82: 80 */     return this.NrMatricula;
/*  83:    */   }
/*  84:    */   
/*  85:    */   public void setNrMatricula(String NrMatricula)
/*  86:    */   {
/*  87: 84 */     this.NrMatricula = NrMatricula;
/*  88:    */   }
/*  89:    */   
/*  90:    */   public String getDotID()
/*  91:    */   {
/*  92: 88 */     return this.DotID;
/*  93:    */   }
/*  94:    */   
/*  95:    */   public void setDotID(String DotID)
/*  96:    */   {
/*  97: 92 */     this.DotID = DotID;
/*  98:    */   }
/*  99:    */   
/* 100:    */   public String getMedidaID()
/* 101:    */   {
/* 102: 96 */     return this.MedidaID;
/* 103:    */   }
/* 104:    */   
/* 105:    */   public void setMedidaID(String MedidaID)
/* 106:    */   {
/* 107:100 */     this.MedidaID = MedidaID;
/* 108:    */   }
/* 109:    */   
/* 110:    */   public String getMarcaID()
/* 111:    */   {
/* 112:104 */     return this.MarcaID;
/* 113:    */   }
/* 114:    */   
/* 115:    */   public void setMarcaID(String MarcaID)
/* 116:    */   {
/* 117:108 */     this.MarcaID = MarcaID;
/* 118:    */   }
/* 119:    */   
/* 120:    */   public String getModeloID()
/* 121:    */   {
/* 122:112 */     return this.ModeloID;
/* 123:    */   }
/* 124:    */   
/* 125:    */   public void setModeloID(String ModeloID)
/* 126:    */   {
/* 127:116 */     this.ModeloID = ModeloID;
/* 128:    */   }
/* 129:    */   
/* 130:    */   public String getStatusID()
/* 131:    */   {
/* 132:120 */     return this.StatusID;
/* 133:    */   }
/* 134:    */   
/* 135:    */   public void setStatusID(String StatusID)
/* 136:    */   {
/* 137:124 */     this.StatusID = StatusID;
/* 138:    */   }
/* 139:    */   
/* 140:    */   public String getLRID()
/* 141:    */   {
/* 142:128 */     return this.LRID;
/* 143:    */   }
/* 144:    */   
/* 145:    */   public void setLRID(String LRID)
/* 146:    */   {
/* 147:132 */     this.LRID = LRID;
/* 148:    */   }
/* 149:    */   
/* 150:    */   public String getVendedorID()
/* 151:    */   {
/* 152:136 */     return this.VendedorID;
/* 153:    */   }
/* 154:    */   
/* 155:    */   public void setVendedorID(String VendedorID)
/* 156:    */   {
/* 157:140 */     this.VendedorID = VendedorID;
/* 158:    */   }
/* 159:    */   
/* 160:    */   public String getColetadorID()
/* 161:    */   {
/* 162:144 */     return this.ColetadorID;
/* 163:    */   }
/* 164:    */   
/* 165:    */   public void setColetadorID(String ColetadorID)
/* 166:    */   {
/* 167:148 */     this.ColetadorID = ColetadorID;
/* 168:    */   }
/* 169:    */   
/* 170:    */   public String getPrazoID()
/* 171:    */   {
/* 172:152 */     return this.PrazoID;
/* 173:    */   }
/* 174:    */   
/* 175:    */   public void setPrazoID(String PrazoID)
/* 176:    */   {
/* 177:156 */     this.PrazoID = PrazoID;
/* 178:    */   }
/* 179:    */   
/* 180:    */   public Date getDtEmisID()
/* 181:    */   {
/* 182:160 */     return this.DtEmisID;
/* 183:    */   }
/* 184:    */   
/* 185:    */   public void setDtEmisID(Date DtEmisID)
/* 186:    */   {
/* 187:164 */     this.DtEmisID = DtEmisID;
/* 188:    */   }
/* 189:    */   
/* 190:    */   public Date getDtprodID()
/* 191:    */   {
/* 192:168 */     return this.DtprodID;
/* 193:    */   }
/* 194:    */   
/* 195:    */   public void setDtprodID(Date DtprodID)
/* 196:    */   {
/* 197:172 */     this.DtprodID = DtprodID;
/* 198:    */   }
/* 199:    */   
/* 200:    */   public Date getDtPrefID()
/* 201:    */   {
/* 202:176 */     return this.DtPrefID;
/* 203:    */   }
/* 204:    */   
/* 205:    */   public void setDtPrefID(Date DtPrefID)
/* 206:    */   {
/* 207:180 */     this.DtPrefID = DtPrefID;
/* 208:    */   }
/* 209:    */   
/* 210:    */   public String getSolicitadoID()
/* 211:    */   {
/* 212:184 */     return this.SolicitadoID;
/* 213:    */   }
/* 214:    */   
/* 215:    */   public void setSolicitadoID(String SolicitadoID)
/* 216:    */   {
/* 217:188 */     this.SolicitadoID = SolicitadoID;
/* 218:    */   }
/* 219:    */   
/* 220:    */   public Long getOcorreuID()
/* 221:    */   {
/* 222:192 */     return this.OcorreuID;
/* 223:    */   }
/* 224:    */   
/* 225:    */   public void setOcorreuID(Long OcorreuID)
/* 226:    */   {
/* 227:196 */     this.OcorreuID = OcorreuID;
/* 228:    */   }
/* 229:    */   
/* 230:    */   public String getMotivoID()
/* 231:    */   {
/* 232:200 */     return this.MotivoID;
/* 233:    */   }
/* 234:    */   
/* 235:    */   public void setMotivoID(String MotivoID)
/* 236:    */   {
/* 237:204 */     this.MotivoID = MotivoID;
/* 238:    */   }
/* 239:    */   
/* 240:    */   public String getERPID()
/* 241:    */   {
/* 242:208 */     return this.ERPID;
/* 243:    */   }
/* 244:    */   
/* 245:    */   public void setERPID(String ERPID)
/* 246:    */   {
/* 247:212 */     this.ERPID = ERPID;
/* 248:    */   }
/* 249:    */   
/* 250:    */   public BigDecimal getValorCarc()
/* 251:    */   {
/* 252:216 */     return this.ValorCarc;
/* 253:    */   }
/* 254:    */   
/* 255:    */   public void setValorCarc(BigDecimal ValorCarc)
/* 256:    */   {
/* 257:220 */     this.ValorCarc = ValorCarc;
/* 258:    */   }
/* 259:    */   
/* 260:    */   public BigDecimal getDescRef()
/* 261:    */   {
/* 262:224 */     return this.DescRef;
/* 263:    */   }
/* 264:    */   
/* 265:    */   public void setDescRef(BigDecimal DescRef)
/* 266:    */   {
/* 267:228 */     this.DescRef = DescRef;
/* 268:    */   }
/* 269:    */   
/* 270:    */   public BigDecimal getDescRep()
/* 271:    */   {
/* 272:232 */     return this.DescRep;
/* 273:    */   }
/* 274:    */   
/* 275:    */   public void setDescRep(BigDecimal DescRep)
/* 276:    */   {
/* 277:236 */     this.DescRep = DescRep;
/* 278:    */   }
/* 279:    */   
/* 280:    */   public BigDecimal getFatRef()
/* 281:    */   {
/* 282:240 */     return this.FatRef;
/* 283:    */   }
/* 284:    */   
/* 285:    */   public void setFatRef(BigDecimal FatRef)
/* 286:    */   {
/* 287:244 */     this.FatRef = FatRef;
/* 288:    */   }
/* 289:    */   
/* 290:    */   public BigDecimal getFatRep()
/* 291:    */   {
/* 292:248 */     return this.FatRep;
/* 293:    */   }
/* 294:    */   
/* 295:    */   public void setFatRep(BigDecimal FatRep)
/* 296:    */   {
/* 297:252 */     this.FatRep = FatRep;
/* 298:    */   }
/* 299:    */   
/* 300:    */   public int getStEI()
/* 301:    */   {
/* 302:256 */     return this.StEI;
/* 303:    */   }
/* 304:    */   
/* 305:    */   public void setStEI(int StEI)
/* 306:    */   {
/* 307:260 */     this.StEI = StEI;
/* 308:    */   }
/* 309:    */   
/* 310:    */   public BigDecimal getVrCom()
/* 311:    */   {
/* 312:266 */     return this.VrCom;
/* 313:    */   }
/* 314:    */   
/* 315:    */   public void setVrCom(BigDecimal VrCom)
/* 316:    */   {
/* 317:270 */     this.VrCom = VrCom;
/* 318:    */   }
/* 319:    */   
/* 320:    */   public String getLauFDC()
/* 321:    */   {
/* 322:274 */     return this.LauFDC;
/* 323:    */   }
/* 324:    */   
/* 325:    */   public void setLauFDC(String LauFDC)
/* 326:    */   {
/* 327:278 */     this.LauFDC = LauFDC;
/* 328:    */   }
/* 329:    */   
/* 330:    */   public String getLauFFC()
/* 331:    */   {
/* 332:282 */     return this.LauFFC;
/* 333:    */   }
/* 334:    */   
/* 335:    */   public void setLauFFC(String LauFFC)
/* 336:    */   {
/* 337:286 */     this.LauFFC = LauFFC;
/* 338:    */   }
/* 339:    */   
/* 340:    */   public Integer getStatusERP()
/* 341:    */   {
/* 342:290 */     return this.StatusERP;
/* 343:    */   }
/* 344:    */   
/* 345:    */   public void setStatusERP(Integer StatusERP)
/* 346:    */   {
/* 347:294 */     this.StatusERP = StatusERP;
/* 348:    */   }
/* 349:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.retreadsystem.modelo.OS_ERP
 * JD-Core Version:    0.7.0.1
 */