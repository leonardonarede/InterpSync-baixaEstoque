/*  1:   */ package br.com.interpsync.interdb.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Resp_Cli;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Resp_CliINTERDBDAO
/* 13:   */ {
/* 14:   */   private Connection connection;
/* 15:   */   
/* 16:   */   public Resp_CliINTERDBDAO()
/* 17:   */   {
/* 18:   */     try
/* 19:   */     {
/* 20:25 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 21:   */     }
/* 22:   */     catch (SQLException ex)
/* 23:   */     {
/* 24:27 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 25:   */     }
/* 26:   */     catch (ClassNotFoundException ex)
/* 27:   */     {
/* 28:29 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 29:   */     }
/* 30:   */     catch (Exception ex)
/* 31:   */     {
/* 32:31 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 33:   */     }
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Connection getConnection()
/* 37:   */     throws SQLException, ClassNotFoundException, Exception
/* 38:   */   {
/* 39:39 */     if ((this.connection == null) || (this.connection.isClosed())) {
/* 40:40 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 41:   */     }
/* 42:42 */     return this.connection;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void inserir(Resp_Cli resp)
/* 46:   */     throws ClassNotFoundException, SQLException, Exception
/* 47:   */   {
/* 48:49 */     String sql = "INSERT INTO Resp_Cli (CNPJCPF,RespVencidas,RespAVencer,StEI) VALUES (?,?,?,?)";
/* 49:   */     
/* 50:51 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 51:52 */     stmt.setString(1, resp.getCNPJCPF());
/* 52:53 */     stmt.setBigDecimal(2, resp.getRespVencidas());
/* 53:54 */     stmt.setBigDecimal(3, resp.getRespAVencer());
/* 54:55 */     stmt.setInt(4, resp.getStEI());
/* 55:56 */     stmt.close();
/* 56:   */   }
/* 57:   */   
/* 58:   */   public void atualizar(Resp_Cli resp)
/* 59:   */     throws ClassNotFoundException, SQLException, Exception
/* 60:   */   {
/* 61:63 */     String sql = "UPDATE Resp_Cli SET RespVencidas = ?, RespAVencer = ?, StEI = ? WHERE CNPJCPF = ?";
/* 62:64 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 63:65 */     stmt.setBigDecimal(1, resp.getRespVencidas());
/* 64:66 */     stmt.setBigDecimal(2, resp.getRespAVencer());
/* 65:67 */     stmt.setInt(3, resp.getStEI());
/* 66:68 */     stmt.executeUpdate();
/* 67:69 */     stmt.close();
/* 68:   */   }
/* 69:   */   
/* 70:   */   public Resp_Cli localizarPorID(String id)
/* 71:   */     throws ClassNotFoundException, SQLException, Exception
/* 72:   */   {
/* 73:76 */     String sql = "SELECT CNPJCPF, RespVencidas, RespAVencer, StEI FROM Resp_Cli WHERE CNPJCPF = ?";
/* 74:77 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 75:78 */     stmt.setString(1, id);
/* 76:79 */     stmt.executeQuery();
/* 77:80 */     ResultSet rs = stmt.getResultSet();
/* 78:81 */     Resp_Cli resp = new Resp_Cli();
/* 79:82 */     if (rs.next())
/* 80:   */     {
/* 81:83 */       resp.setCNPJCPF(rs.getString("CNPJCPF"));
/* 82:84 */       resp.setRespVencidas(rs.getBigDecimal("RespVencidas"));
/* 83:85 */       resp.setRespAVencer(rs.getBigDecimal("RespAVencer"));
/* 84:86 */       resp.setStEI(rs.getInt("StEI"));
/* 85:   */     }
/* 86:88 */     stmt.close();
/* 87:89 */     return resp;
/* 88:   */   }
/* 89:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Resp_CliINTERDBDAO
 * JD-Core Version:    0.7.0.1
 */