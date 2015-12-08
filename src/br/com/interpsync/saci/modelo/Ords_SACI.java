/*   1:    */ package br.com.interpsync.saci.modelo;
/*   2:    */ 
/*   3:    */ public class Ords_SACI
/*   4:    */ {
/*   5:    */   private Integer no;
/*   6:    */   private Integer data;
/*   7:    */   private Integer vendno;
/*   8:    */   private Integer storeno;
/*   9:    */   private Integer empno;
/*  10:    */   private String remarks;
/*  11:    */   private Integer status;
/*  12:    */   private String ordnoFromVend;
/*  13: 20 */   private Integer discountOrig = Integer.valueOf(0);
/*  14: 21 */   private Integer l1 = Integer.valueOf(0);
/*  15: 22 */   private Integer l2 = Integer.valueOf(0);
/*  16: 23 */   private Integer l3 = Integer.valueOf(0);
/*  17: 24 */   private Integer l4 = Integer.valueOf(0);
/*  18: 25 */   private Integer m1 = Integer.valueOf(0);
/*  19: 26 */   private Integer m2 = Integer.valueOf(0);
/*  20: 27 */   private Integer m3 = Integer.valueOf(0);
/*  21: 28 */   private Integer m4 = Integer.valueOf(0);
/*  22: 29 */   private Integer bits3 = Integer.valueOf(0);
/*  23: 30 */   private Integer s1 = Integer.valueOf(0);
/*  24: 31 */   private Integer s2 = Integer.valueOf(0);
/*  25: 32 */   private Integer s3 = Integer.valueOf(0);
/*  26: 33 */   private Integer s4 = Integer.valueOf(0);
/*  27: 34 */   private String c1 = " ";
/*  28: 35 */   private String c2 = " ";
/*  29: 36 */   private String c3 = " ";
/*  30: 37 */   private String c4 = " ";
/*  31:    */   private Integer auxShort2;
/*  32:    */   
/*  33:    */   public Integer getNo()
/*  34:    */   {
/*  35: 41 */     return this.no;
/*  36:    */   }
/*  37:    */   
/*  38:    */   public void setNo(Integer no)
/*  39:    */   {
/*  40: 45 */     this.no = no;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public Integer getData()
/*  44:    */   {
/*  45: 49 */     return this.data;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public void setData(Integer data)
/*  49:    */   {
/*  50: 53 */     this.data = data;
/*  51:    */   }
/*  52:    */   
/*  53:    */   public Integer getVendno()
/*  54:    */   {
/*  55: 57 */     return this.vendno;
/*  56:    */   }
/*  57:    */   
/*  58:    */   public void setVendno(Integer vendno)
/*  59:    */   {
/*  60: 61 */     this.vendno = vendno;
/*  61:    */   }
/*  62:    */   
/*  63:    */   public Integer getStoreno()
/*  64:    */   {
/*  65: 65 */     return this.storeno;
/*  66:    */   }
/*  67:    */   
/*  68:    */   public void setStoreno(Integer storeno)
/*  69:    */   {
/*  70: 69 */     this.storeno = storeno;
/*  71:    */   }
/*  72:    */   
/*  73:    */   public Integer getEmpno()
/*  74:    */   {
/*  75: 73 */     return this.empno;
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void setEmpno(Integer empno)
/*  79:    */   {
/*  80: 77 */     this.empno = empno;
/*  81:    */   }
/*  82:    */   
/*  83:    */   public String getRemarks()
/*  84:    */   {
/*  85: 81 */     return this.remarks;
/*  86:    */   }
/*  87:    */   
/*  88:    */   public void setRemarks(String remarks)
/*  89:    */   {
/*  90: 85 */     this.remarks = remarks;
/*  91:    */   }
/*  92:    */   
/*  93:    */   public Integer getStatus()
/*  94:    */   {
/*  95: 89 */     return this.status;
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void setStatus(Integer status)
/*  99:    */   {
/* 100: 93 */     this.status = status;
/* 101:    */   }
/* 102:    */   
/* 103:    */   public String getOrdnoFromVend()
/* 104:    */   {
/* 105: 97 */     return this.ordnoFromVend;
/* 106:    */   }
/* 107:    */   
/* 108:    */   public void setOrdnoFromVend(String ordnoFromVend)
/* 109:    */   {
/* 110:101 */     this.ordnoFromVend = ordnoFromVend;
/* 111:    */   }
/* 112:    */   
/* 113:    */   public Integer getDiscountOrig()
/* 114:    */   {
/* 115:105 */     return this.discountOrig;
/* 116:    */   }
/* 117:    */   
/* 118:    */   public void setDiscountOrig(Integer discountOrig)
/* 119:    */   {
/* 120:109 */     this.discountOrig = discountOrig;
/* 121:    */   }
/* 122:    */   
/* 123:    */   public Integer getL1()
/* 124:    */   {
/* 125:113 */     return this.l1;
/* 126:    */   }
/* 127:    */   
/* 128:    */   public void setL1(Integer l1)
/* 129:    */   {
/* 130:117 */     this.l1 = l1;
/* 131:    */   }
/* 132:    */   
/* 133:    */   public Integer getL2()
/* 134:    */   {
/* 135:121 */     return this.l2;
/* 136:    */   }
/* 137:    */   
/* 138:    */   public void setL2(Integer l2)
/* 139:    */   {
/* 140:125 */     this.l2 = l2;
/* 141:    */   }
/* 142:    */   
/* 143:    */   public Integer getL3()
/* 144:    */   {
/* 145:129 */     return this.l3;
/* 146:    */   }
/* 147:    */   
/* 148:    */   public void setL3(Integer l3)
/* 149:    */   {
/* 150:133 */     this.l3 = l3;
/* 151:    */   }
/* 152:    */   
/* 153:    */   public Integer getL4()
/* 154:    */   {
/* 155:137 */     return this.l4;
/* 156:    */   }
/* 157:    */   
/* 158:    */   public void setL4(Integer l4)
/* 159:    */   {
/* 160:141 */     this.l4 = l4;
/* 161:    */   }
/* 162:    */   
/* 163:    */   public Integer getM1()
/* 164:    */   {
/* 165:145 */     return this.m1;
/* 166:    */   }
/* 167:    */   
/* 168:    */   public void setM1(Integer m1)
/* 169:    */   {
/* 170:149 */     this.m1 = m1;
/* 171:    */   }
/* 172:    */   
/* 173:    */   public Integer getM2()
/* 174:    */   {
/* 175:153 */     return this.m2;
/* 176:    */   }
/* 177:    */   
/* 178:    */   public void setM2(Integer m2)
/* 179:    */   {
/* 180:157 */     this.m2 = m2;
/* 181:    */   }
/* 182:    */   
/* 183:    */   public Integer getM3()
/* 184:    */   {
/* 185:161 */     return this.m3;
/* 186:    */   }
/* 187:    */   
/* 188:    */   public void setM3(Integer m3)
/* 189:    */   {
/* 190:165 */     this.m3 = m3;
/* 191:    */   }
/* 192:    */   
/* 193:    */   public Integer getM4()
/* 194:    */   {
/* 195:169 */     return this.m4;
/* 196:    */   }
/* 197:    */   
/* 198:    */   public void setM4(Integer m4)
/* 199:    */   {
/* 200:173 */     this.m4 = m4;
/* 201:    */   }
/* 202:    */   
/* 203:    */   public Integer getBits3()
/* 204:    */   {
/* 205:177 */     return this.bits3;
/* 206:    */   }
/* 207:    */   
/* 208:    */   public void setBits3(Integer bits3)
/* 209:    */   {
/* 210:181 */     this.bits3 = bits3;
/* 211:    */   }
/* 212:    */   
/* 213:    */   public Integer getS1()
/* 214:    */   {
/* 215:185 */     return this.s1;
/* 216:    */   }
/* 217:    */   
/* 218:    */   public void setS1(Integer s1)
/* 219:    */   {
/* 220:189 */     this.s1 = s1;
/* 221:    */   }
/* 222:    */   
/* 223:    */   public Integer getS2()
/* 224:    */   {
/* 225:193 */     return this.s2;
/* 226:    */   }
/* 227:    */   
/* 228:    */   public void setS2(Integer s2)
/* 229:    */   {
/* 230:197 */     this.s2 = s2;
/* 231:    */   }
/* 232:    */   
/* 233:    */   public Integer getS3()
/* 234:    */   {
/* 235:201 */     return this.s3;
/* 236:    */   }
/* 237:    */   
/* 238:    */   public void setS3(Integer s3)
/* 239:    */   {
/* 240:205 */     this.s3 = s3;
/* 241:    */   }
/* 242:    */   
/* 243:    */   public Integer getS4()
/* 244:    */   {
/* 245:209 */     return this.s4;
/* 246:    */   }
/* 247:    */   
/* 248:    */   public void setS4(Integer s4)
/* 249:    */   {
/* 250:213 */     this.s4 = s4;
/* 251:    */   }
/* 252:    */   
/* 253:    */   public String getC1()
/* 254:    */   {
/* 255:217 */     return this.c1;
/* 256:    */   }
/* 257:    */   
/* 258:    */   public void setC1(String c1)
/* 259:    */   {
/* 260:221 */     this.c1 = c1;
/* 261:    */   }
/* 262:    */   
/* 263:    */   public String getC2()
/* 264:    */   {
/* 265:225 */     return this.c2;
/* 266:    */   }
/* 267:    */   
/* 268:    */   public void setC2(String c2)
/* 269:    */   {
/* 270:229 */     this.c2 = c2;
/* 271:    */   }
/* 272:    */   
/* 273:    */   public String getC3()
/* 274:    */   {
/* 275:233 */     return this.c3;
/* 276:    */   }
/* 277:    */   
/* 278:    */   public void setC3(String c3)
/* 279:    */   {
/* 280:237 */     this.c3 = c3;
/* 281:    */   }
/* 282:    */   
/* 283:    */   public String getC4()
/* 284:    */   {
/* 285:241 */     return this.c4;
/* 286:    */   }
/* 287:    */   
/* 288:    */   public void setC4(String c4)
/* 289:    */   {
/* 290:245 */     this.c4 = c4;
/* 291:    */   }
/* 292:    */   
/* 293:    */   public Integer getAuxShort2()
/* 294:    */   {
/* 295:249 */     return this.auxShort2;
/* 296:    */   }
/* 297:    */   
/* 298:    */   public void setAuxShort2(Integer auxShort2)
/* 299:    */   {
/* 300:253 */     this.auxShort2 = auxShort2;
/* 301:    */   }
/* 302:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.saci.modelo.Ords_SACI
 * JD-Core Version:    0.7.0.1
 */