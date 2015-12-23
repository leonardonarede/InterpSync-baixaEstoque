/*  1:   */ package br.com.interpsync.saci.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.saci.jdbc.ConnectionFactorySACI;
/*  4:   */ import br.com.interpsync.saci.modelo.Ords_SACI;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Ords_SACIDAO
/* 13:   */ {
/* 14:   */   private Connection conexao;
              private Integer Loja;
/* 15:   */   
/* 16:   */   public Ords_SACIDAO()
/* 17:   */   {
/* 18:   */     try
/* 19:   */     {
/* 20:25 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
                  String local = new File("./bdconfig.txt").getCanonicalFile().toString();
                  File arq = new File(local);
                  boolean existe = arq.exists();  
                  if (existe){
                      FileReader fr = new FileReader( arq );
                      BufferedReader br = new BufferedReader( fr );
                      while(br.ready()){
                          String linha = br.readLine();
                          if(linha.contains("SACILoja:")){
                             Loja = Integer.parseInt(linha.replace("SACILoja:", "").replace(" ", ""));
                          }
                      }
                  }
/* 21:   */     }
/* 22:   */     catch (SQLException ex)
/* 23:   */     {
/* 24:27 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 25:   */     }
/* 26:   */     catch (ClassNotFoundException ex)
/* 27:   */     {
/* 28:29 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 29:   */     }
/* 30:   */     catch (Exception ex)
/* 31:   */     {
/* 32:31 */       Logger.getLogger(Cliente_SACIDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 33:   */     }
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Connection getConnection()
/* 37:   */     throws SQLException, ClassNotFoundException, Exception
/* 38:   */   {
/* 39:39 */     if ((this.conexao == null) || (this.conexao.isClosed())) {
/* 40:40 */       this.conexao = ConnectionFactorySACI.getInstance().obterConexao();
/* 41:   */     }
/* 42:42 */     return this.conexao;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void inserir(Ords_SACI ords)
/* 46:   */     throws ClassNotFoundException, SQLException, Exception
/* 47:   */   {
/* 48:49 */     String sql = "INSERT INTO ords (no,date,vendno,storeno,empno,remarks,status,ordnoFromVend,    discountOrig, l1, l2, l3, l4, m1, m2, m3, m4, bits3, s1, s2, s3, s4, c1, c2, c3, c4, dataFaturamento, auxShort2)    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
/* 49:   */     
/* 50:   */ 
/* 51:52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 52:53 */     stmt.setInt(1, ords.getNo().intValue());
/* 53:54 */     stmt.setInt(2, ords.getData().intValue());
/* 54:55 */     stmt.setInt(3, ords.getVendno().intValue());
/* 55:56 */     stmt.setInt(4, Loja);
/* 56:57 */     stmt.setInt(5, ords.getEmpno().intValue());
/* 57:58 */     stmt.setString(6, ords.getRemarks());
/* 58:59 */     stmt.setInt(7, ords.getStatus().intValue());
/* 59:60 */     stmt.setString(8, ords.getOrdnoFromVend());
/* 60:61 */     stmt.setInt(9, ords.getDiscountOrig().intValue());
/* 61:62 */     stmt.setInt(10, ords.getL1().intValue());
/* 62:63 */     stmt.setInt(11, ords.getL2().intValue());
/* 63:64 */     stmt.setInt(12, ords.getL3().intValue());
/* 64:65 */     stmt.setInt(13, ords.getL4().intValue());
/* 65:66 */     stmt.setInt(14, ords.getM1().intValue());
/* 66:67 */     stmt.setInt(15, ords.getM2().intValue());
/* 67:68 */     stmt.setInt(16, ords.getM3().intValue());
/* 68:69 */     stmt.setInt(17, ords.getM4().intValue());
/* 69:70 */     stmt.setInt(18, ords.getBits3().intValue());
/* 70:71 */     stmt.setInt(19, ords.getS1().intValue());
/* 71:72 */     stmt.setInt(20, ords.getS2().intValue());
/* 72:73 */     stmt.setInt(21, ords.getS3().intValue());
/* 73:74 */     stmt.setInt(22, ords.getS4().intValue());
/* 74:75 */     stmt.setString(23, ords.getC1());
/* 75:76 */     stmt.setString(24, ords.getC2());
/* 76:77 */     stmt.setString(25, ords.getC3());
/* 77:78 */     stmt.setString(26, ords.getC4());
/* 78:79 */     stmt.setInt(27, ords.getData().intValue());
/* 79:80 */     stmt.setInt(28, ords.getAuxShort2().intValue());
/* 80:81 */     stmt.executeUpdate();
/* 81:82 */     stmt.close();
/* 82:   */   }
/* 83:   */   
/* 84:   */   public Integer buscaUlt()
/* 85:   */     throws ClassNotFoundException, SQLException, Exception
/* 86:   */   {
/* 87:89 */     String sql = "SELECT MAX(ords.no) AS ult FROM ords WHERE ords.storeno = ? ";
/* 88:90 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
                stmt.setInt(1, Loja);
/* 89:91 */     stmt.executeQuery();
/* 90:92 */     Integer ultimo = null;
/* 91:93 */     ResultSet rs = stmt.getResultSet();
/* 92:94 */     if (rs.next()) {
/* 93:95 */       ultimo = Integer.valueOf(rs.getInt("ult"));
/* 94:   */     }
/* 95:97 */     return ultimo;
/* 96:   */   }
/* 97:   */ }



/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar

 * Qualified Name:     br.com.interpsync.saci.dao.Ords_SACIDAO

 * JD-Core Version:    0.7.0.1

 */