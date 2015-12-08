/*   1:    */ package br.com.interpsync.saci.modelo;
/*   2:    */ 
/*   3:    */ public class Fornecedor_SACI
/*   4:    */ {
/*   5:    */   private Integer no;
/*   6:    */   private String name;
/*   7:    */   private String sname;
/*   8:    */   private String cgc;
/*   9:    */   private String insc;
/*  10:    */   private String nei;
/*  11:    */   private String city;
/*  12:    */   private String state;
/*  13:    */   private String auxChar1;
/*  14:    */   private Integer zip;
/*  15:    */   private String ext;
/*  16:    */   private String coll;
/*  17:    */   private Integer fabOufor;
/*  18: 25 */   private Integer l1 = Integer.valueOf(0);
/*  19: 26 */   private Integer l2 = Integer.valueOf(0);
/*  20: 27 */   private Integer l3 = Integer.valueOf(0);
/*  21: 28 */   private Integer l4 = Integer.valueOf(0);
/*  22: 29 */   private Integer l5 = Integer.valueOf(0);
/*  23: 30 */   private Integer l6 = Integer.valueOf(0);
/*  24: 31 */   private Integer l7 = Integer.valueOf(0);
/*  25: 32 */   private Integer l8 = Integer.valueOf(0);
/*  26: 33 */   private Integer m1 = Integer.valueOf(0);
/*  27: 34 */   private Integer m2 = Integer.valueOf(0);
/*  28: 35 */   private Integer m3 = Integer.valueOf(0);
/*  29: 36 */   private Integer m4 = Integer.valueOf(0);
/*  30: 37 */   private Integer m5 = Integer.valueOf(0);
/*  31: 38 */   private Integer m6 = Integer.valueOf(0);
/*  32: 39 */   private Integer m7 = Integer.valueOf(0);
/*  33: 40 */   private Integer m8 = Integer.valueOf(0);
/*  34: 41 */   private Integer auxShort4 = Integer.valueOf(0);
/*  35: 42 */   private Integer s1 = Integer.valueOf(0);
/*  36: 43 */   private Integer s2 = Integer.valueOf(0);
/*  37: 44 */   private Integer s3 = Integer.valueOf(0);
/*  38: 45 */   private Integer s4 = Integer.valueOf(0);
/*  39: 46 */   private Integer s5 = Integer.valueOf(0);
/*  40: 47 */   private Integer s6 = Integer.valueOf(0);
/*  41: 48 */   private Integer s7 = Integer.valueOf(0);
/*  42: 49 */   private Integer s8 = Integer.valueOf(0);
/*  43:    */   private String addr;
/*  44: 51 */   private String c1 = " ";
/*  45: 52 */   private String wshash = " ";
/*  46:    */   
/*  47:    */   public Integer getNo()
/*  48:    */   {
/*  49: 55 */     return this.no;
/*  50:    */   }
/*  51:    */   
/*  52:    */   public void setNo(Integer no)
/*  53:    */   {
/*  54: 59 */     this.no = no;
/*  55:    */   }
/*  56:    */   
/*  57:    */   public String getName()
/*  58:    */   {
/*  59: 63 */     return this.name;
/*  60:    */   }
/*  61:    */   
/*  62:    */   public void setName(String name)
/*  63:    */   {
/*  64: 67 */     this.name = name;
/*  65:    */   }
/*  66:    */   
/*  67:    */   public String getSname()
/*  68:    */   {
/*  69: 71 */     return this.sname;
/*  70:    */   }
/*  71:    */   
/*  72:    */   public void setSname(String sname)
/*  73:    */   {
/*  74: 75 */     this.sname = sname;
/*  75:    */   }
/*  76:    */   
/*  77:    */   public String getCgc()
/*  78:    */   {
/*  79: 79 */     return this.cgc;
/*  80:    */   }
/*  81:    */   
/*  82:    */   public void setCgc(String cgc)
/*  83:    */   {
/*  84: 83 */     this.cgc = cgc;
/*  85:    */   }
/*  86:    */   
/*  87:    */   public String getInsc()
/*  88:    */   {
/*  89: 87 */     return this.insc;
/*  90:    */   }
/*  91:    */   
/*  92:    */   public void setInsc(String insc)
/*  93:    */   {
/*  94: 91 */     this.insc = insc;
/*  95:    */   }
/*  96:    */   
/*  97:    */   public String getNei()
/*  98:    */   {
/*  99: 95 */     return this.nei;
/* 100:    */   }
/* 101:    */   
/* 102:    */   public void setNei(String nei)
/* 103:    */   {
/* 104: 99 */     this.nei = nei;
/* 105:    */   }
/* 106:    */   
/* 107:    */   public String getCity()
/* 108:    */   {
/* 109:103 */     return this.city;
/* 110:    */   }
/* 111:    */   
/* 112:    */   public void setCity(String city)
/* 113:    */   {
/* 114:107 */     this.city = city;
/* 115:    */   }
/* 116:    */   
/* 117:    */   public String getState()
/* 118:    */   {
/* 119:111 */     return this.state;
/* 120:    */   }
/* 121:    */   
/* 122:    */   public void setState(String state)
/* 123:    */   {
/* 124:115 */     this.state = state;
/* 125:    */   }
/* 126:    */   
/* 127:    */   public String getAuxChar1()
/* 128:    */   {
/* 129:119 */     return this.auxChar1;
/* 130:    */   }
/* 131:    */   
/* 132:    */   public void setAuxChar1(String auxChar1)
/* 133:    */   {
/* 134:123 */     this.auxChar1 = auxChar1;
/* 135:    */   }
/* 136:    */   
/* 137:    */   public Integer getZip()
/* 138:    */   {
/* 139:127 */     return this.zip;
/* 140:    */   }
/* 141:    */   
/* 142:    */   public void setZip(Integer zip)
/* 143:    */   {
/* 144:131 */     this.zip = zip;
/* 145:    */   }
/* 146:    */   
/* 147:    */   public String getExt()
/* 148:    */   {
/* 149:135 */     return this.ext;
/* 150:    */   }
/* 151:    */   
/* 152:    */   public void setExt(String ext)
/* 153:    */   {
/* 154:139 */     this.ext = ext;
/* 155:    */   }
/* 156:    */   
/* 157:    */   public String getColl()
/* 158:    */   {
/* 159:143 */     return this.coll;
/* 160:    */   }
/* 161:    */   
/* 162:    */   public void setColl(String coll)
/* 163:    */   {
/* 164:147 */     this.coll = coll;
/* 165:    */   }
/* 166:    */   
/* 167:    */   public Integer getFabOufor()
/* 168:    */   {
/* 169:151 */     return this.fabOufor;
/* 170:    */   }
/* 171:    */   
/* 172:    */   public void setFabOufor(Integer fabOufor)
/* 173:    */   {
/* 174:155 */     this.fabOufor = fabOufor;
/* 175:    */   }
/* 176:    */   
/* 177:    */   public Integer getL1()
/* 178:    */   {
/* 179:159 */     return this.l1;
/* 180:    */   }
/* 181:    */   
/* 182:    */   public void setL1(Integer l1)
/* 183:    */   {
/* 184:163 */     this.l1 = l1;
/* 185:    */   }
/* 186:    */   
/* 187:    */   public Integer getL2()
/* 188:    */   {
/* 189:167 */     return this.l2;
/* 190:    */   }
/* 191:    */   
/* 192:    */   public void setL2(Integer l2)
/* 193:    */   {
/* 194:171 */     this.l2 = l2;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public Integer getL3()
/* 198:    */   {
/* 199:175 */     return this.l3;
/* 200:    */   }
/* 201:    */   
/* 202:    */   public void setL3(Integer l3)
/* 203:    */   {
/* 204:179 */     this.l3 = l3;
/* 205:    */   }
/* 206:    */   
/* 207:    */   public Integer getL4()
/* 208:    */   {
/* 209:183 */     return this.l4;
/* 210:    */   }
/* 211:    */   
/* 212:    */   public void setL4(Integer l4)
/* 213:    */   {
/* 214:187 */     this.l4 = l4;
/* 215:    */   }
/* 216:    */   
/* 217:    */   public Integer getL5()
/* 218:    */   {
/* 219:191 */     return this.l5;
/* 220:    */   }
/* 221:    */   
/* 222:    */   public void setL5(Integer l5)
/* 223:    */   {
/* 224:195 */     this.l5 = l5;
/* 225:    */   }
/* 226:    */   
/* 227:    */   public Integer getL6()
/* 228:    */   {
/* 229:199 */     return this.l6;
/* 230:    */   }
/* 231:    */   
/* 232:    */   public void setL6(Integer l6)
/* 233:    */   {
/* 234:203 */     this.l6 = l6;
/* 235:    */   }
/* 236:    */   
/* 237:    */   public Integer getL7()
/* 238:    */   {
/* 239:207 */     return this.l7;
/* 240:    */   }
/* 241:    */   
/* 242:    */   public void setL7(Integer l7)
/* 243:    */   {
/* 244:211 */     this.l7 = l7;
/* 245:    */   }
/* 246:    */   
/* 247:    */   public Integer getL8()
/* 248:    */   {
/* 249:215 */     return this.l8;
/* 250:    */   }
/* 251:    */   
/* 252:    */   public void setL8(Integer l8)
/* 253:    */   {
/* 254:219 */     this.l8 = l8;
/* 255:    */   }
/* 256:    */   
/* 257:    */   public Integer getM1()
/* 258:    */   {
/* 259:223 */     return this.m1;
/* 260:    */   }
/* 261:    */   
/* 262:    */   public void setM1(Integer m1)
/* 263:    */   {
/* 264:227 */     this.m1 = m1;
/* 265:    */   }
/* 266:    */   
/* 267:    */   public Integer getM2()
/* 268:    */   {
/* 269:231 */     return this.m2;
/* 270:    */   }
/* 271:    */   
/* 272:    */   public void setM2(Integer m2)
/* 273:    */   {
/* 274:235 */     this.m2 = m2;
/* 275:    */   }
/* 276:    */   
/* 277:    */   public Integer getM3()
/* 278:    */   {
/* 279:239 */     return this.m3;
/* 280:    */   }
/* 281:    */   
/* 282:    */   public void setM3(Integer m3)
/* 283:    */   {
/* 284:243 */     this.m3 = m3;
/* 285:    */   }
/* 286:    */   
/* 287:    */   public Integer getM4()
/* 288:    */   {
/* 289:247 */     return this.m4;
/* 290:    */   }
/* 291:    */   
/* 292:    */   public void setM4(Integer m4)
/* 293:    */   {
/* 294:251 */     this.m4 = m4;
/* 295:    */   }
/* 296:    */   
/* 297:    */   public Integer getM5()
/* 298:    */   {
/* 299:255 */     return this.m5;
/* 300:    */   }
/* 301:    */   
/* 302:    */   public void setM5(Integer m5)
/* 303:    */   {
/* 304:259 */     this.m5 = m5;
/* 305:    */   }
/* 306:    */   
/* 307:    */   public Integer getM6()
/* 308:    */   {
/* 309:263 */     return this.m6;
/* 310:    */   }
/* 311:    */   
/* 312:    */   public void setM6(Integer m6)
/* 313:    */   {
/* 314:267 */     this.m6 = m6;
/* 315:    */   }
/* 316:    */   
/* 317:    */   public Integer getM7()
/* 318:    */   {
/* 319:271 */     return this.m7;
/* 320:    */   }
/* 321:    */   
/* 322:    */   public void setM7(Integer m7)
/* 323:    */   {
/* 324:275 */     this.m7 = m7;
/* 325:    */   }
/* 326:    */   
/* 327:    */   public Integer getM8()
/* 328:    */   {
/* 329:279 */     return this.m8;
/* 330:    */   }
/* 331:    */   
/* 332:    */   public void setM8(Integer m8)
/* 333:    */   {
/* 334:283 */     this.m8 = m8;
/* 335:    */   }
/* 336:    */   
/* 337:    */   public Integer getAuxShort4()
/* 338:    */   {
/* 339:287 */     return this.auxShort4;
/* 340:    */   }
/* 341:    */   
/* 342:    */   public void setAuxShort4(Integer auxShort4)
/* 343:    */   {
/* 344:291 */     this.auxShort4 = auxShort4;
/* 345:    */   }
/* 346:    */   
/* 347:    */   public Integer getS1()
/* 348:    */   {
/* 349:295 */     return this.s1;
/* 350:    */   }
/* 351:    */   
/* 352:    */   public void setS1(Integer s1)
/* 353:    */   {
/* 354:299 */     this.s1 = s1;
/* 355:    */   }
/* 356:    */   
/* 357:    */   public Integer getS2()
/* 358:    */   {
/* 359:303 */     return this.s2;
/* 360:    */   }
/* 361:    */   
/* 362:    */   public void setS2(Integer s2)
/* 363:    */   {
/* 364:307 */     this.s2 = s2;
/* 365:    */   }
/* 366:    */   
/* 367:    */   public Integer getS3()
/* 368:    */   {
/* 369:311 */     return this.s3;
/* 370:    */   }
/* 371:    */   
/* 372:    */   public void setS3(Integer s3)
/* 373:    */   {
/* 374:315 */     this.s3 = s3;
/* 375:    */   }
/* 376:    */   
/* 377:    */   public Integer getS4()
/* 378:    */   {
/* 379:319 */     return this.s4;
/* 380:    */   }
/* 381:    */   
/* 382:    */   public void setS4(Integer s4)
/* 383:    */   {
/* 384:323 */     this.s4 = s4;
/* 385:    */   }
/* 386:    */   
/* 387:    */   public Integer getS5()
/* 388:    */   {
/* 389:327 */     return this.s5;
/* 390:    */   }
/* 391:    */   
/* 392:    */   public void setS5(Integer s5)
/* 393:    */   {
/* 394:331 */     this.s5 = s5;
/* 395:    */   }
/* 396:    */   
/* 397:    */   public Integer getS6()
/* 398:    */   {
/* 399:335 */     return this.s6;
/* 400:    */   }
/* 401:    */   
/* 402:    */   public void setS6(Integer s6)
/* 403:    */   {
/* 404:339 */     this.s6 = s6;
/* 405:    */   }
/* 406:    */   
/* 407:    */   public Integer getS7()
/* 408:    */   {
/* 409:343 */     return this.s7;
/* 410:    */   }
/* 411:    */   
/* 412:    */   public void setS7(Integer s7)
/* 413:    */   {
/* 414:347 */     this.s7 = s7;
/* 415:    */   }
/* 416:    */   
/* 417:    */   public Integer getS8()
/* 418:    */   {
/* 419:351 */     return this.s8;
/* 420:    */   }
/* 421:    */   
/* 422:    */   public void setS8(Integer s8)
/* 423:    */   {
/* 424:355 */     this.s8 = s8;
/* 425:    */   }
/* 426:    */   
/* 427:    */   public String getAddr()
/* 428:    */   {
/* 429:359 */     return this.addr;
/* 430:    */   }
/* 431:    */   
/* 432:    */   public void setAddr(String addr)
/* 433:    */   {
/* 434:363 */     this.addr = addr;
/* 435:    */   }
/* 436:    */   
/* 437:    */   public String getC1()
/* 438:    */   {
/* 439:367 */     return this.c1;
/* 440:    */   }
/* 441:    */   
/* 442:    */   public void setC1(String c1)
/* 443:    */   {
/* 444:371 */     this.c1 = c1;
/* 445:    */   }
/* 446:    */   
/* 447:    */   public String getWshash()
/* 448:    */   {
/* 449:375 */     return this.wshash;
/* 450:    */   }
/* 451:    */   
/* 452:    */   public void setWshash(String wshash)
/* 453:    */   {
/* 454:379 */     this.wshash = wshash;
/* 455:    */   }
/* 456:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.saci.modelo.Fornecedor_SACI
 * JD-Core Version:    0.7.0.1
 */