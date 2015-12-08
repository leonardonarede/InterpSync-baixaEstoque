/*   1:    */ package br.com.interpsync.interdb.dao;
/*   2:    */ 
/*   3:    */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*   4:    */ import br.com.interpsync.retreadsystem.modelo.Lotes_ERP;
/*   5:    */ import br.com.interpsync.retreadsystem.modelo.OS_ERP;
/*   6:    */ import java.sql.Connection;
/*   7:    */ import java.sql.PreparedStatement;
/*   8:    */ import java.sql.ResultSet;
/*   9:    */ import java.sql.SQLException;
/*  10:    */ import java.util.ArrayList;
/*  11:    */ import java.util.List;
/*  12:    */ import java.util.logging.Level;
/*  13:    */ import java.util.logging.Logger;
/*  14:    */ 
/*  15:    */ public class OS_INTERDBDAO
/*  16:    */ {
/*  17:    */   private Connection connection;
/*  18:    */   
/*  19:    */   public OS_INTERDBDAO()
/*  20:    */   {
/*  21:    */     try
/*  22:    */     {
/*  23: 31 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/*  24:    */     }
/*  25:    */     catch (SQLException ex)
/*  26:    */     {
/*  27: 33 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  28:    */     }
/*  29:    */     catch (ClassNotFoundException ex)
/*  30:    */     {
/*  31: 35 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  32:    */     }
/*  33:    */     catch (Exception ex)
/*  34:    */     {
/*  35: 37 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/*  36:    */     }
/*  37:    */   }
/*  38:    */   
/*  39:    */   public Connection getConnection()
/*  40:    */     throws SQLException, ClassNotFoundException, Exception
/*  41:    */   {
/*  42: 45 */     if ((this.connection == null) || (this.connection.isClosed())) {
/*  43: 46 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/*  44:    */     }
/*  45: 48 */     return this.connection;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public void inserir(OS_ERP os)
/*  49:    */     throws SQLException, ClassNotFoundException, Exception
/*  50:    */   {
/*  51: 55 */     String sql = "INSERT INTO OS_ERP (NrOS,NrLote,ClienteID,NrMatricula,MedidaID,MarcaID,ModeloID,StatusID, LRID,VendedorID,ColetadorID,PrazoID,DtEmisID,DtprodID,DtPrefID,SolicitadoID,MotivoID, ValorCarc,DescRef,DescRep,FatRef,FatRep,StEI,VrCom,LauFDC,LauFFC)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
/*  52:    */     
/*  53:    */ 
/*  54:    */ 
/*  55: 59 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/*  56: 60 */     stmt.setInt(1, os.getNrOS().intValue());
/*  57: 61 */     stmt.setInt(2, os.getNrLote().intValue());
/*  58: 62 */     stmt.setString(3, os.getClienteID());
/*  59: 63 */     stmt.setString(4, os.getNrMatricula());
/*  60: 64 */     stmt.setString(5, os.getMedidaID());
/*  61: 65 */     stmt.setString(6, os.getMarcaID());
/*  62: 66 */     stmt.setString(7, os.getModeloID());
/*  63: 67 */     stmt.setString(8, os.getStatusID());
/*  64: 68 */     stmt.setString(9, os.getLRID());
/*  65: 69 */     stmt.setString(10, os.getVendedorID());
/*  66: 70 */     stmt.setString(11, os.getColetadorID());
/*  67: 71 */     stmt.setString(12, os.getPrazoID());
/*  68: 72 */     if (os.getDtEmisID() != null) {
/*  69: 73 */       stmt.setDate(13, new java.sql.Date(os.getDtEmisID().getTime()));
/*  70:    */     } else {
/*  71: 75 */       stmt.setDate(13, new java.sql.Date(1L));
/*  72:    */     }
/*  73: 78 */     if (os.getDtprodID() != null) {
/*  74: 79 */       stmt.setDate(14, new java.sql.Date(os.getDtprodID().getTime()));
/*  75:    */     } else {
/*  76: 81 */       stmt.setDate(14, new java.sql.Date(1L));
/*  77:    */     }
/*  78: 83 */     if (os.getDtPrefID() != null) {
/*  79: 84 */       stmt.setDate(15, new java.sql.Date(os.getDtPrefID().getTime()));
/*  80:    */     } else {
/*  81: 86 */       stmt.setDate(15, new java.sql.Date(1L));
/*  82:    */     }
/*  83: 88 */     stmt.setString(16, os.getSolicitadoID());
/*  84: 89 */     stmt.setString(17, os.getMotivoID());
/*  85: 90 */     stmt.setBigDecimal(18, os.getValorCarc());
/*  86: 91 */     stmt.setBigDecimal(19, os.getDescRef());
/*  87: 92 */     stmt.setBigDecimal(20, os.getDescRep());
/*  88: 93 */     stmt.setBigDecimal(21, os.getFatRef());
/*  89: 94 */     stmt.setBigDecimal(22, os.getFatRep());
/*  90: 95 */     stmt.setInt(23, os.getStEI());
/*  91: 96 */     stmt.setBigDecimal(24, os.getVrCom());
/*  92: 97 */     stmt.setString(25, os.getLauFDC());
/*  93: 98 */     stmt.setString(26, os.getLauFFC());
/*  94: 99 */     stmt.executeUpdate();
/*  95:100 */     stmt.close();
/*  96:    */   }
/*  97:    */   
/*  98:    */   public void atualizar(OS_ERP os)
/*  99:    */     throws ClassNotFoundException, SQLException, Exception
/* 100:    */   {
/* 101:107 */     String sql = "UPDATE OS_ERP SET NrLote = ?,ClienteID = ?,NrMatricula = ?,MedidaID = ?,MarcaID = ?,ModeloID = ?,StatusID = ?, LRID = ?,VendedorID = ?,ColetadorID = ?,PrazoID = ?,DtEmisID =?,DtprodID = ?,DtPrefID = ?,SolicitadoID = ?,MotivoID = ?, ValorCarc = ?,DescRef = ?,DescRep = ?,FatRef = ?,FatRep = ?,StEI =?,VrCom = ?,LauFDC = ?,LauFFC = ?, StatusERP = ? WHERE NrOS = ? ";
/* 102:    */     
/* 103:    */ 
/* 104:110 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 105:111 */     stmt.setInt(1, os.getNrLote().intValue());
/* 106:112 */     stmt.setString(2, os.getClienteID());
/* 107:113 */     stmt.setString(3, os.getNrMatricula());
/* 108:114 */     stmt.setString(4, os.getMedidaID());
/* 109:115 */     stmt.setString(5, os.getMarcaID());
/* 110:116 */     stmt.setString(6, os.getModeloID());
/* 111:117 */     stmt.setString(7, os.getStatusID());
/* 112:118 */     stmt.setString(8, os.getLRID());
/* 113:119 */     stmt.setString(9, os.getVendedorID());
/* 114:120 */     stmt.setString(10, os.getColetadorID());
/* 115:121 */     stmt.setString(11, os.getPrazoID());
/* 116:122 */     if (os.getDtprodID() != null) {
/* 117:123 */       stmt.setDate(12, new java.sql.Date(os.getDtEmisID().getTime()));
/* 118:    */     } else {
/* 119:125 */       stmt.setDate(12, new java.sql.Date(1L));
/* 120:    */     }
/* 121:128 */     if (os.getDtprodID() != null) {
/* 122:129 */       stmt.setDate(13, new java.sql.Date(os.getDtprodID().getTime()));
/* 123:    */     } else {
/* 124:131 */       stmt.setDate(13, new java.sql.Date(1L));
/* 125:    */     }
/* 126:133 */     if (os.getDtPrefID() != null) {
/* 127:134 */       stmt.setDate(14, new java.sql.Date(os.getDtPrefID().getTime()));
/* 128:    */     } else {
/* 129:136 */       stmt.setDate(14, new java.sql.Date(1L));
/* 130:    */     }
/* 131:139 */     stmt.setString(15, os.getSolicitadoID());
/* 132:140 */     stmt.setString(16, os.getMotivoID());
/* 133:141 */     stmt.setBigDecimal(17, os.getValorCarc());
/* 134:142 */     stmt.setBigDecimal(18, os.getDescRef());
/* 135:143 */     stmt.setBigDecimal(19, os.getDescRep());
/* 136:144 */     stmt.setBigDecimal(20, os.getFatRef());
/* 137:145 */     stmt.setBigDecimal(21, os.getFatRep());
/* 138:146 */     stmt.setInt(22, os.getStEI());
/* 139:147 */     stmt.setBigDecimal(23, os.getVrCom());
/* 140:148 */     stmt.setString(24, os.getLauFDC());
/* 141:149 */     stmt.setString(25, os.getLauFFC());
/* 142:150 */     stmt.setInt(26, os.getStatusERP().intValue());
/* 143:151 */     stmt.setInt(27, os.getNrOS().intValue());
/* 144:152 */     stmt.executeUpdate();
/* 145:153 */     stmt.close();
/* 146:    */   }
/* 147:    */   
/* 148:    */   public OS_ERP localizarPorID(int id)
/* 149:    */     throws ClassNotFoundException, SQLException, Exception
/* 150:    */   {
/* 151:160 */     String sql = "SELECT NrOS, NrLote, ClienteID, NrMatricula,    MedidaID, MarcaID, ModeloID, StatusID, LRID, VendedorID, ColetadorID,    PrazoID, DtEmisID, DtprodID, DtPrefID, SolicitadoID, MotivoID,    ValorCarc, DescRef, DescRep, FatRef, FatRep, StEI, VrCom, LauFDC,    LauFFC, StatusERP  FROM OS_ERP WHERE NrOS = ?";
/* 152:    */     
/* 153:    */ 
/* 154:    */ 
/* 155:    */ 
/* 156:165 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 157:166 */     stmt.setInt(1, id);
/* 158:167 */     stmt.executeQuery();
/* 159:168 */     ResultSet rs = stmt.getResultSet();
/* 160:169 */     OS_ERP os = new OS_ERP();
/* 161:170 */     if (rs.first())
/* 162:    */     {
/* 163:171 */       os.setNrOS(Integer.valueOf(rs.getInt("NrOS")));
/* 164:172 */       os.setNrLote(Integer.valueOf(rs.getInt("NrLote")));
/* 165:173 */       os.setClienteID(rs.getString("ClienteID"));
/* 166:174 */       os.setNrMatricula(rs.getString("NrMatricula"));
/* 167:175 */       os.setMedidaID(rs.getString("MedidaID"));
/* 168:176 */       os.setMarcaID(rs.getString("MarcaID"));
/* 169:177 */       os.setModeloID(rs.getString("ModeloID"));
/* 170:178 */       os.setStatusID(rs.getString("StatusID"));
/* 171:179 */       os.setLRID(rs.getString("LRID"));
/* 172:180 */       os.setVendedorID(rs.getString("VendedorID"));
/* 173:181 */       os.setColetadorID(rs.getString("ColetadorID"));
/* 174:182 */       os.setPrazoID(rs.getString("PrazoID"));
/* 175:    */       
/* 176:184 */       os.setDtEmisID(rs.getDate("DtEmisID"));
/* 177:185 */       os.setDtprodID(rs.getDate("DtprodID"));
/* 178:186 */       os.setDtPrefID(rs.getDate("DtPrefID"));
/* 179:    */       
/* 180:188 */       os.setSolicitadoID(rs.getString("SolicitadoID"));
/* 181:189 */       os.setMotivoID(rs.getString("MotivoID"));
/* 182:190 */       os.setValorCarc(rs.getBigDecimal("ValorCarc"));
/* 183:191 */       os.setDescRef(rs.getBigDecimal("DescRef"));
/* 184:192 */       os.setDescRep(rs.getBigDecimal("DescRep"));
/* 185:193 */       os.setFatRef(rs.getBigDecimal("FatRef"));
/* 186:194 */       os.setFatRep(rs.getBigDecimal("FatRep"));
/* 187:195 */       os.setStEI(rs.getInt("StEI"));
/* 188:196 */       os.setVrCom(rs.getBigDecimal("VrCom"));
/* 189:197 */       os.setLauFDC(rs.getString("LauFDC"));
/* 190:198 */       os.setLauFFC(rs.getString("LauFFC"));
/* 191:199 */       os.setStatusERP(Integer.valueOf(rs.getInt("StatusERP")));
/* 192:    */     }
/* 193:201 */     stmt.close();
/* 194:202 */     return os;
/* 195:    */   }
/* 196:    */   
/* 197:    */   public List<OS_ERP> listarEstPendente()
/* 198:    */     throws ClassNotFoundException, SQLException, Exception
/* 199:    */   {
/* 200:209 */     String sql = "SELECT NrOS, NrLote, ClienteID, NrMatricula,    MedidaID, MarcaID, ModeloID, StatusID, LRID, VendedorID, ColetadorID,    PrazoID, DtEmisID, DtprodID, DtPrefID, SolicitadoID, MotivoID,    ValorCarc, DescRef, DescRep, FatRef, FatRep, StEI, VrCom, LauFDC,    LauFFC FROM OS_ERP WHERE ERPID = 1 AND StEI = 5";
/* 201:    */     
/* 202:    */ 
/* 203:    */ 
/* 204:    */ 
/* 205:214 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 206:215 */     stmt.executeQuery();
/* 207:216 */     ResultSet rs = stmt.getResultSet();
/* 208:217 */     List<OS_ERP> lista = new ArrayList();
/* 209:218 */     while (rs.next())
/* 210:    */     {
/* 211:219 */       OS_ERP os = new OS_ERP();
/* 212:220 */       os.setNrOS(Integer.valueOf(rs.getInt("NrOS")));
/* 213:221 */       os.setNrLote(Integer.valueOf(rs.getInt("NrLote")));
/* 214:222 */       os.setClienteID(rs.getString("ClienteID"));
/* 215:223 */       os.setNrMatricula(rs.getString("NrMatricula"));
/* 216:224 */       os.setMedidaID(rs.getString("MedidaID"));
/* 217:225 */       os.setMarcaID(rs.getString("MarcaID"));
/* 218:226 */       os.setModeloID(rs.getString("ModeloID"));
/* 219:227 */       os.setStatusID(rs.getString("StatusID"));
/* 220:228 */       os.setLRID(rs.getString("LRID"));
/* 221:229 */       os.setVendedorID(rs.getString("VendedorID"));
/* 222:230 */       os.setColetadorID(rs.getString("ColetadorID"));
/* 223:231 */       os.setPrazoID(rs.getString("PrazoID"));
/* 224:    */       
/* 225:233 */       os.setDtEmisID(rs.getDate("DtEmisID"));
/* 226:234 */       os.setDtprodID(rs.getDate("DtprodID"));
/* 227:235 */       os.setDtPrefID(rs.getDate("DtPrefID"));
/* 228:    */       
/* 229:237 */       os.setSolicitadoID(rs.getString("SolicitadoID"));
/* 230:238 */       os.setMotivoID(rs.getString("MotivoID"));
/* 231:239 */       os.setValorCarc(rs.getBigDecimal("ValorCarc"));
/* 232:240 */       os.setDescRef(rs.getBigDecimal("DescRef"));
/* 233:241 */       os.setDescRep(rs.getBigDecimal("DescRep"));
/* 234:242 */       os.setFatRef(rs.getBigDecimal("FatRef"));
/* 235:243 */       os.setFatRep(rs.getBigDecimal("FatRep"));
/* 236:244 */       os.setStEI(rs.getInt("StEI"));
/* 237:245 */       os.setVrCom(rs.getBigDecimal("VrCom"));
/* 238:246 */       os.setLauFDC(rs.getString("LauFDC"));
/* 239:247 */       os.setLauFFC(rs.getString("LauFFC"));
/* 240:248 */       lista.add(os);
/* 241:    */     }
/* 242:250 */     stmt.close();
/* 243:251 */     return lista;
/* 244:    */   }
/* 245:    */   
/* 246:    */   public List<Lotes_ERP> listaLotesPendentesSACI()
/* 247:    */     throws ClassNotFoundException, Exception
/* 248:    */   {
/* 249:257 */     String sql = "SELECT NrLote, ClienteID FROM OS_ERP WHERE StatusERP = 0 GROUP BY 1 ";
/* 250:258 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 251:259 */     stmt.executeQuery();
/* 252:260 */     ResultSet rs = stmt.getResultSet();
/* 253:261 */     List<Lotes_ERP> listagem = new ArrayList();
/* 254:262 */     while (rs.next())
/* 255:    */     {
/* 256:263 */       Lotes_ERP lote = new Lotes_ERP();
/* 257:264 */       lote.setNrLote(Integer.valueOf(rs.getInt("NrLote")));
/* 258:265 */       lote.setClienteID(rs.getString("ClienteID"));
/* 259:266 */       listagem.add(lote);
/* 260:    */     }
/* 261:268 */     return listagem;
/* 262:    */   }
/* 263:    */   
/* 264:    */   public List<OS_ERP> listarOsPendenteSACI(Integer lote)
/* 265:    */     throws ClassNotFoundException, SQLException, Exception
/* 266:    */   {
/* 267:275 */     String sql = "SELECT NrOS, NrLote, ClienteID, NrMatricula,    MedidaID, MarcaID, ModeloID, StatusID, LRID, VendedorID, ColetadorID,    PrazoID, DtEmisID, DtprodID, DtPrefID, SolicitadoID, MotivoID,    ValorCarc, DescRef, DescRep, FatRef, FatRep, StEI, VrCom, LauFDC,    LauFFC FROM OS_ERP WHERE StatusERP = 0 AND NrLote = ? AND id > 25671 ";
/* 268:    */     
/* 269:    */ 
/* 270:    */ 
/* 271:    */ 
/* 272:280 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 273:281 */     stmt.setInt(1, lote.intValue());
/* 274:282 */     stmt.executeQuery();
/* 275:283 */     ResultSet rs = stmt.getResultSet();
/* 276:284 */     List<OS_ERP> lista = new ArrayList();
/* 277:285 */     while (rs.next())
/* 278:    */     {
/* 279:286 */       OS_ERP os = new OS_ERP();
/* 280:287 */       os.setNrOS(Integer.valueOf(rs.getInt("NrOS")));
/* 281:288 */       os.setNrLote(Integer.valueOf(rs.getInt("NrLote")));
/* 282:289 */       os.setClienteID(rs.getString("ClienteID"));
/* 283:290 */       os.setNrMatricula(rs.getString("NrMatricula"));
/* 284:291 */       os.setMedidaID(rs.getString("MedidaID"));
/* 285:292 */       os.setMarcaID(rs.getString("MarcaID"));
/* 286:293 */       os.setModeloID(rs.getString("ModeloID"));
/* 287:294 */       os.setStatusID(rs.getString("StatusID"));
/* 288:295 */       os.setLRID(rs.getString("LRID"));
/* 289:296 */       os.setVendedorID(rs.getString("VendedorID"));
/* 290:297 */       os.setColetadorID(rs.getString("ColetadorID"));
/* 291:298 */       os.setPrazoID(rs.getString("PrazoID"));
/* 292:    */       
/* 293:300 */       os.setDtEmisID(rs.getDate("DtEmisID"));
/* 294:301 */       os.setDtprodID(rs.getDate("DtprodID"));
/* 295:302 */       os.setDtPrefID(rs.getDate("DtPrefID"));
/* 296:    */       
/* 297:304 */       os.setSolicitadoID(rs.getString("SolicitadoID"));
/* 298:305 */       os.setMotivoID(rs.getString("MotivoID"));
/* 299:306 */       os.setValorCarc(rs.getBigDecimal("ValorCarc"));
/* 300:307 */       os.setDescRef(rs.getBigDecimal("DescRef"));
/* 301:308 */       os.setDescRep(rs.getBigDecimal("DescRep"));
/* 302:309 */       os.setFatRef(rs.getBigDecimal("FatRef"));
/* 303:310 */       os.setFatRep(rs.getBigDecimal("FatRep"));
/* 304:311 */       os.setStEI(rs.getInt("StEI"));
/* 305:312 */       os.setVrCom(rs.getBigDecimal("VrCom"));
/* 306:313 */       os.setLauFDC(rs.getString("LauFDC"));
/* 307:314 */       os.setLauFFC(rs.getString("LauFFC"));
/* 308:315 */       lista.add(os);
/* 309:    */     }
/* 310:317 */     stmt.close();
/* 311:318 */     return lista;
/* 312:    */   }
/* 313:    */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.OS_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */