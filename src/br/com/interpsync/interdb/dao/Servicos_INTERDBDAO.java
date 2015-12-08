/*  1:   */ package br.com.interpsync.interdb.dao;
/*  2:   */ 
/*  3:   */ import br.com.interpsync.interdb.jdbc.ConnectionFactoryInterDB;
/*  4:   */ import br.com.interpsync.retreadsystem.modelo.Servicos_ERP;
/*  5:   */ import java.sql.Connection;
/*  6:   */ import java.sql.PreparedStatement;
/*  7:   */ import java.sql.ResultSet;
/*  8:   */ import java.sql.SQLException;
/*  9:   */ import java.util.logging.Level;
/* 10:   */ import java.util.logging.Logger;
/* 11:   */ 
/* 12:   */ public class Servicos_INTERDBDAO
/* 13:   */ {
/* 14:   */   private Connection connection;
/* 15:   */   
/* 16:   */   public Servicos_INTERDBDAO()
/* 17:   */   {
/* 18:   */     try
/* 19:   */     {
/* 20:26 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 21:   */     }
/* 22:   */     catch (SQLException ex)
/* 23:   */     {
/* 24:28 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 25:   */     }
/* 26:   */     catch (ClassNotFoundException ex)
/* 27:   */     {
/* 28:30 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 29:   */     }
/* 30:   */     catch (Exception ex)
/* 31:   */     {
/* 32:32 */       Logger.getLogger(Clientes_INTERDBDAO.class.getName()).log(Level.SEVERE, null, ex);
/* 33:   */     }
/* 34:   */   }
/* 35:   */   
/* 36:   */   public Connection getConnection()
/* 37:   */     throws SQLException, ClassNotFoundException, Exception
/* 38:   */   {
/* 39:40 */     if ((this.connection == null) || (this.connection.isClosed())) {
/* 40:41 */       this.connection = ConnectionFactoryInterDB.getInstance().obterConexao();
/* 41:   */     }
/* 42:43 */     return this.connection;
/* 43:   */   }
/* 44:   */   
/* 45:   */   public void inserir(Servicos_ERP servico)
/* 46:   */     throws ClassNotFoundException, SQLException, Exception
/* 47:   */   {
/* 48:50 */     String sql = "INSERT INTO SERVICOS_ERP (CodSE,DescrSE,ValorSE,Stei) VALUES (?,?,?,?)";
/* 49:   */     
/* 50:52 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 51:53 */     stmt.setString(1, servico.getCodSE());
/* 52:54 */     stmt.setString(2, servico.getDescrSE());
/* 53:55 */     stmt.setBigDecimal(3, servico.getValorSE());
/* 54:56 */     stmt.setInt(4, servico.getStei());
/* 55:57 */     stmt.executeUpdate();
/* 56:58 */     stmt.close();
/* 57:   */   }
/* 58:   */   
/* 59:   */   public void atualizar(Servicos_ERP servico)
/* 60:   */     throws ClassNotFoundException, SQLException, Exception
/* 61:   */   {
/* 62:65 */     String sql = "UPDATE SERVICOS_ERP SET DescrSE = ?, ValorSE = ?, Stei = ? WHERE CodSE = ?";
/* 63:66 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 64:67 */     stmt.setString(1, servico.getDescrSE());
/* 65:68 */     stmt.setBigDecimal(2, servico.getValorSE());
/* 66:69 */     stmt.setInt(3, servico.getStei());
/* 67:70 */     stmt.executeUpdate();
/* 68:71 */     stmt.close();
/* 69:   */   }
/* 70:   */   
/* 71:   */   public Servicos_ERP localizarPorID(String id)
/* 72:   */     throws ClassNotFoundException, SQLException, Exception
/* 73:   */   {
/* 74:78 */     String sql = "SELECT CodSE, DescrSE, ValorSE, Stei FROM SERVICOS_ERP WHERE CodSE = ?";
/* 75:79 */     PreparedStatement stmt = getConnection().prepareStatement(sql);
/* 76:80 */     stmt.setString(1, id);
/* 77:81 */     stmt.executeQuery();
/* 78:82 */     ResultSet rs = stmt.getResultSet();
/* 79:83 */     Servicos_ERP servico = new Servicos_ERP();
/* 80:84 */     if (rs.next())
/* 81:   */     {
/* 82:85 */       servico.setCodSE(rs.getString("CodSE"));
/* 83:86 */       servico.setDescrSE(rs.getString("DescrSE"));
/* 84:87 */       servico.setValorSE(rs.getBigDecimal("ValorSE"));
/* 85:88 */       servico.setStei(rs.getInt("Stei"));
/* 86:   */     }
/* 87:90 */     stmt.close();
/* 88:91 */     return servico;
/* 89:   */   }
/* 90:   */ }


/* Location:           C:\Users\Leonardo\Desktop\INT\InterpSync.jar
 * Qualified Name:     br.com.interpsync.interdb.dao.Servicos_INTERDBDAO
 * JD-Core Version:    0.7.0.1
 */