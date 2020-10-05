/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgBangsal.java
 *
 * Created on May 22, 2010, 9:58:42 PM
 */

package kepegawaian;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author dosen
 */
public final class DlgTemporaryPresensi extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private PreparedStatement ps;
    private ResultSet rs; 
    int i=0;
    /** Creates new form DlgBangsal
     * @param parent
     * @param modal */
    public DlgTemporaryPresensi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Object[] row={"P","Id","NIK","Nama","Shift","Jam Datang","Saat Ini","Status","Keterlambatan","Durasi","Photo"};
        tabMode=new DefaultTableModel(null,row){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){
                boolean a = false;
                if (colIndex==0) {
                    a=true;
                }
                return a;
             }
             Class[] types = new Class[] {
                java.lang.Boolean.class, java.lang.Object.class,  java.lang.Object.class,  java.lang.Object.class,  
                java.lang.Object.class,  java.lang.Object.class,  java.lang.Object.class,  java.lang.Object.class,  
                java.lang.Object.class,  java.lang.Object.class, java.lang.Object.class,
             };
             @Override
             public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
             }
        };
        tbTemporary.setModel(tabMode);

        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
        tbTemporary.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbTemporary.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 11; i++) {
            TableColumn column = tbTemporary.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(20);
            }else if(i==1){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else if(i==2){
                column.setPreferredWidth(90);
            }else if(i==3){
                column.setPreferredWidth(200);
            }else if(i==4){
                column.setPreferredWidth(90);
            }else if(i==5){
                column.setPreferredWidth(125);
            }else if(i==6){
                column.setPreferredWidth(125);
            }else if(i==10){
                column.setMinWidth(0);
                column.setMaxWidth(0);
            }else{
                column.setPreferredWidth(115);
            }
        }
        tbTemporary.setDefaultRenderer(Object.class, new WarnaTable());
        
        TCari.setDocument(new batasInput((int)100).getKata(TCari));
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
            });
        }  
        
    }

    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Popup2 = new javax.swing.JPopupMenu();
        ppVerify = new javax.swing.JMenuItem();
        ppVerifySemua = new javax.swing.JMenuItem();
        ppHapusSemua = new javax.swing.JMenuItem();
        ppPilihSemua = new javax.swing.JMenuItem();
        ppBersihkanSemua = new javax.swing.JMenuItem();
        ppVerifyOtomatis = new javax.swing.JMenuItem();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbTemporary = new widget.Table();
        jPanel1 = new javax.swing.JPanel();
        panelGlass7 = new widget.panelisi();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        jLabel7 = new widget.Label();
        LCount = new widget.Label();
        panelGlass5 = new widget.panelisi();
        BtnTambah = new widget.Button();
        BtnHapus = new widget.Button();
        BtnPrint = new widget.Button();
        BtnAll = new widget.Button();
        BtnKeluar = new widget.Button();

        Popup2.setName("Popup2"); // NOI18N

        ppVerify.setBackground(new java.awt.Color(255, 255, 254));
        ppVerify.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppVerify.setForeground(new java.awt.Color(50,50,50));
        ppVerify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppVerify.setText("Verifikasi Presensi Yang Lebih Dari 16 Jam");
        ppVerify.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppVerify.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppVerify.setIconTextGap(8);
        ppVerify.setName("ppVerify"); // NOI18N
        ppVerify.setPreferredSize(new java.awt.Dimension(250, 25));
        ppVerify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppVerifyActionPerformed(evt);
            }
        });
        Popup2.add(ppVerify);

        ppVerifySemua.setBackground(new java.awt.Color(255, 255, 254));
        ppVerifySemua.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppVerifySemua.setForeground(new java.awt.Color(50,50,50));
        ppVerifySemua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppVerifySemua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppVerifySemua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppVerifySemua.setIconTextGap(8);
        ppVerifySemua.setLabel("Verifikasi Semua Presensi");
        ppVerifySemua.setName("ppVerifySemua"); // NOI18N
        ppVerifySemua.setPreferredSize(new java.awt.Dimension(250, 25));
        ppVerifySemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppVerifySemuaActionPerformed(evt);
            }
        });
        Popup2.add(ppVerifySemua);

        ppHapusSemua.setBackground(new java.awt.Color(255, 255, 254));
        ppHapusSemua.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppHapusSemua.setForeground(new java.awt.Color(50,50,50));
        ppHapusSemua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppHapusSemua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppHapusSemua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppHapusSemua.setIconTextGap(8);
        ppHapusSemua.setLabel("Hapus Semua");
        ppHapusSemua.setName("ppHapusSemua"); // NOI18N
        ppHapusSemua.setPreferredSize(new java.awt.Dimension(250, 25));
        ppHapusSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppHapusSemuaActionPerformed(evt);
            }
        });
        Popup2.add(ppHapusSemua);

        ppPilihSemua.setBackground(new java.awt.Color(255, 255, 254));
        ppPilihSemua.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppPilihSemua.setForeground(new java.awt.Color(50,50,50));
        ppPilihSemua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppPilihSemua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppPilihSemua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppPilihSemua.setIconTextGap(8);
        ppPilihSemua.setLabel("Pilih Semua");
        ppPilihSemua.setName("ppPilihSemua"); // NOI18N
        ppPilihSemua.setPreferredSize(new java.awt.Dimension(250, 25));
        ppPilihSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppPilihSemuaActionPerformed(evt);
            }
        });
        Popup2.add(ppPilihSemua);

        ppBersihkanSemua.setBackground(new java.awt.Color(255, 255, 254));
        ppBersihkanSemua.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppBersihkanSemua.setForeground(new java.awt.Color(50,50,50));
        ppBersihkanSemua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppBersihkanSemua.setText("Bersihkan Pilihan");
        ppBersihkanSemua.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppBersihkanSemua.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppBersihkanSemua.setIconTextGap(8);
        ppBersihkanSemua.setName("ppBersihkanSemua"); // NOI18N
        ppBersihkanSemua.setPreferredSize(new java.awt.Dimension(250, 25));
        ppBersihkanSemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppBersihkanSemuaActionPerformed(evt);
            }
        });
        Popup2.add(ppBersihkanSemua);

        ppVerifyOtomatis.setBackground(new java.awt.Color(255, 255, 254));
        ppVerifyOtomatis.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppVerifyOtomatis.setForeground(new java.awt.Color(50,50,50));
        ppVerifyOtomatis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        ppVerifyOtomatis.setText("Jalan Verifikasi Otomatis");
        ppVerifyOtomatis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppVerifyOtomatis.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppVerifyOtomatis.setIconTextGap(8);
        ppVerifyOtomatis.setName("ppVerifyOtomatis"); // NOI18N
        ppVerifyOtomatis.setPreferredSize(new java.awt.Dimension(250, 25));
        ppVerifyOtomatis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppVerifyOtomatisActionPerformed(evt);
            }
        });
        Popup2.add(ppVerifyOtomatis);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setIconImages(null);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Temporary Presensi ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50,50,50))); // NOI18N
        internalFrame1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setComponentPopupMenu(Popup2);
        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbTemporary.setAutoCreateRowSorter(true);
        tbTemporary.setComponentPopupMenu(Popup2);
        tbTemporary.setName("tbTemporary"); // NOI18N
        Scroll.setViewportView(tbTemporary);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass7.setName("panelGlass7"); // NOI18N
        panelGlass7.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(66, 23));
        jLabel6.setRequestFocusEnabled(false);
        panelGlass7.add(jLabel6);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(300, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass7.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('1');
        BtnCari.setToolTipText("Alt+1");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass7.add(BtnCari);

        jLabel7.setText("Record :");
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass7.add(jLabel7);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass7.add(LCount);

        jPanel1.add(panelGlass7, java.awt.BorderLayout.PAGE_START);

        panelGlass5.setName("panelGlass5"); // NOI18N
        panelGlass5.setPreferredSize(new java.awt.Dimension(55, 55));
        panelGlass5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/add-file-16x16.png"))); // NOI18N
        BtnTambah.setMnemonic('A');
        BtnTambah.setText("Verifi");
        BtnTambah.setToolTipText("Alt+A");
        BtnTambah.setName("BtnTambah"); // NOI18N
        BtnTambah.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });
        BtnTambah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnTambahKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnTambah);

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapus.setMnemonic('H');
        BtnHapus.setText("Hapus");
        BtnHapus.setToolTipText("Alt+H");
        BtnHapus.setName("BtnHapus"); // NOI18N
        BtnHapus.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });
        BtnHapus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnHapus);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnPrint);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnAll);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass5.add(BtnKeluar);

        jPanel1.add(panelGlass5, java.awt.BorderLayout.CENTER);

        internalFrame1.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
}//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
}//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        
        for(i=0;i<tbTemporary.getRowCount();i++){ 
            if(tbTemporary.getValueAt(i,0).toString().equals("true")){
                Sequel.queryu2("insert into rekap_presensi values(?,?,?,?,?,?,?,?,?)", 9,new String[]{
                    tbTemporary.getValueAt(i,1).toString(),tbTemporary.getValueAt(i,4).toString(),
                    tbTemporary.getValueAt(i,5).toString(),tbTemporary.getValueAt(i,6).toString(),
                    tbTemporary.getValueAt(i,7).toString(),tbTemporary.getValueAt(i,8).toString(),
                    tbTemporary.getValueAt(i,9).toString(),"-",tbTemporary.getValueAt(i,10).toString(),
                });
                Sequel.queryu2("delete from temporary_presensi where id=? and jam_datang=?",2,new String[]{
                    tbTemporary.getValueAt(i,1).toString(),tbTemporary.getValueAt(i,5).toString()
                });
            }
        }
        
        tampil();
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnTambahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnTambahKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnTambahActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnHapus);
        }
    }//GEN-LAST:event_BtnTambahKeyPressed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        
        for(i=0;i<tbTemporary.getRowCount();i++){ 
            if(tbTemporary.getValueAt(i,0).toString().equals("true")){
                Sequel.queryu2("delete from temporary_presensi where id=? and jam_datang=?",2,new String[]{
                    tbTemporary.getValueAt(i,1).toString(),tbTemporary.getValueAt(i,5).toString()
                });
            }
        }
        
        tampil();
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnHapusActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnTambah, BtnPrint);
        }
    }//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(! TCari.getText().trim().equals("")){
            BtnCariActionPerformed(evt);
        }
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            Map<String, Object> param = new HashMap<>();   
                param.put("namars",akses.getnamars());
                param.put("alamatrs",akses.getalamatrs());
                param.put("kotars",akses.getkabupatenrs());
                param.put("propinsirs",akses.getpropinsirs());
                param.put("kontakrs",akses.getkontakrs());
                param.put("emailrs",akses.getemailrs());   
                param.put("logo",Sequel.cariGambar("select logo from setting")); 
                Valid.MyReportqry("rptTemporaryPresensi.jasper","report","::[ Temporary Presensi ]::",
                    "SELECT pegawai.id, pegawai.nik, pegawai.nama, temporary_presensi.shift, " +
                    "temporary_presensi.jam_datang, now() as jam_pulang, temporary_presensi.status,  " +
                    "temporary_presensi.keterlambatan, ((unix_timestamp(now()) - unix_timestamp(jam_datang))/3600) as durasi,temporary_presensi.photo  from pegawai  " +
                    "inner join temporary_presensi on pegawai.id=temporary_presensi.id " +
                    "where  pegawai.nik like '%"+TCari.getText().trim()+"%' or " +
                    "pegawai.nama like '%"+TCari.getText().trim()+"%' or " +
                    "temporary_presensi.shift like '%"+TCari.getText().trim()+"%' or " +
                    "temporary_presensi.jam_datang like '%"+TCari.getText().trim()+"%' or " +
                    "temporary_presensi.status like '%"+TCari.getText().trim()+"%' or " +
                    "temporary_presensi.keterlambatan like '%"+TCari.getText().trim()+"%' ",param);            
        }
        this.setCursor(Cursor.getDefaultCursor());
        
    }//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt,BtnHapus,BtnAll);
        }
    }//GEN-LAST:event_BtnPrintKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
    }//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnAllActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnPrint, BtnKeluar);
        }
    }//GEN-LAST:event_BtnAllKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            dispose();
        }else{Valid.pindah(evt,BtnAll,TCari);}
    }//GEN-LAST:event_BtnKeluarKeyPressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil();
    }//GEN-LAST:event_formWindowOpened

    private void ppVerifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppVerifyActionPerformed
        
        for(i=0;i<tbTemporary.getRowCount();i++){ 
            if(Double.parseDouble(tbTemporary.getValueAt(i,9).toString())>16){
                Sequel.queryu2("insert into rekap_presensi values(?,?,?,?,?,?,?,?,?)", 9,new String[]{
                    tbTemporary.getValueAt(i,1).toString(),tbTemporary.getValueAt(i,4).toString(),
                    tbTemporary.getValueAt(i,5).toString(),tbTemporary.getValueAt(i,6).toString(),
                    tbTemporary.getValueAt(i,7).toString(),tbTemporary.getValueAt(i,8).toString(),
                    tbTemporary.getValueAt(i,9).toString(),"-",tbTemporary.getValueAt(i,10).toString(),
                });
                Sequel.queryu2("delete from temporary_presensi where id=? and jam_datang=?",2,new String[]{
                    tbTemporary.getValueAt(i,1).toString(),tbTemporary.getValueAt(i,5).toString()
                });
            }
        }
        
        tampil();
    }//GEN-LAST:event_ppVerifyActionPerformed

    private void ppVerifySemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppVerifySemuaActionPerformed
        
        for(i=0;i<tbTemporary.getRowCount();i++){ 
                Sequel.queryu2("insert into rekap_presensi values(?,?,?,?,?,?,?,?,?)", 9,new String[]{
                    tbTemporary.getValueAt(i,1).toString(),tbTemporary.getValueAt(i,4).toString(),
                    tbTemporary.getValueAt(i,5).toString(),tbTemporary.getValueAt(i,6).toString(),
                    tbTemporary.getValueAt(i,7).toString(),tbTemporary.getValueAt(i,8).toString(),
                    tbTemporary.getValueAt(i,9).toString(),"-",tbTemporary.getValueAt(i,10).toString(),
                });
                Sequel.queryu2("delete from temporary_presensi where id=? and jam_datang=?",2,new String[]{
                    tbTemporary.getValueAt(i,1).toString(),tbTemporary.getValueAt(i,5).toString()
                });
        }
        
        tampil();
    }//GEN-LAST:event_ppVerifySemuaActionPerformed

    private void ppHapusSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppHapusSemuaActionPerformed
        
        for(i=0;i<tbTemporary.getRowCount();i++){ 
                Sequel.queryu2("delete from temporary_presensi where id=? and jam_datang=?",2,new String[]{
                    tbTemporary.getValueAt(i,1).toString(),tbTemporary.getValueAt(i,5).toString()
                });
        }
        
        tampil();
    }//GEN-LAST:event_ppHapusSemuaActionPerformed

    private void ppPilihSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppPilihSemuaActionPerformed
        for(i=0;i<tbTemporary.getRowCount();i++){ 
            tbTemporary.setValueAt(true,i,0);
        }        
    }//GEN-LAST:event_ppPilihSemuaActionPerformed

    private void ppVerifyOtomatisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppVerifyOtomatisActionPerformed
        try {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            Runtime.getRuntime().exec("java -jar autoverifiy.jar");
            this.setCursor(Cursor.getDefaultCursor());
        } catch (Exception e) {
            System.out.print("Notifikasi : "+e);
        } 
    }//GEN-LAST:event_ppVerifyOtomatisActionPerformed

    private void ppBersihkanSemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppBersihkanSemuaActionPerformed
        for(i=0;i<tbTemporary.getRowCount();i++){ 
            tbTemporary.setValueAt(false,i,0);
        }
    }//GEN-LAST:event_ppBersihkanSemuaActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgTemporaryPresensi dialog = new DlgTemporaryPresensi(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnCari;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnTambah;
    private widget.Label LCount;
    private javax.swing.JPopupMenu Popup2;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private javax.swing.JPanel jPanel1;
    private widget.panelisi panelGlass5;
    private widget.panelisi panelGlass7;
    private javax.swing.JMenuItem ppBersihkanSemua;
    private javax.swing.JMenuItem ppHapusSemua;
    private javax.swing.JMenuItem ppPilihSemua;
    private javax.swing.JMenuItem ppVerify;
    private javax.swing.JMenuItem ppVerifyOtomatis;
    private javax.swing.JMenuItem ppVerifySemua;
    private widget.Table tbTemporary;
    // End of variables declaration//GEN-END:variables

    public void tampil() {
        Valid.tabelKosong(tabMode);
        try{   
            ps=koneksi.prepareStatement(
                    "SELECT pegawai.id, pegawai.nik, pegawai.nama, temporary_presensi.shift, " +
                    "temporary_presensi.jam_datang, now() as jam_pulang, temporary_presensi.status,  " +
                    "temporary_presensi.keterlambatan, ((unix_timestamp(now()) - unix_timestamp(jam_datang))/3600) as durasi,temporary_presensi.photo  from pegawai  " +
                    "inner join temporary_presensi on pegawai.id=temporary_presensi.id " +
                    "where  pegawai.nik like ? or " +
                    "pegawai.nama like ? or " +
                    "temporary_presensi.shift like ? or " +
                    "temporary_presensi.jam_datang like ? or " +
                    "temporary_presensi.status like ? or " +
                    "temporary_presensi.keterlambatan like ?  ");
            try {
                ps.setString(1,"%"+TCari.getText().trim()+"%");
                ps.setString(2,"%"+TCari.getText().trim()+"%");
                ps.setString(3,"%"+TCari.getText().trim()+"%");
                ps.setString(4,"%"+TCari.getText().trim()+"%");
                ps.setString(5,"%"+TCari.getText().trim()+"%");
                ps.setString(6,"%"+TCari.getText().trim()+"%");
                rs=ps.executeQuery(); 
                while(rs.next()){
                    tabMode.addRow(new Object[]{
                        false,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
                        rs.getString(9),rs.getString(10)
                    });
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText(""+tabMode.getRowCount());

    }

    public void isCek(){
        BtnTambah.setEnabled(akses.gettemporary_presensi());
        BtnHapus.setEnabled(akses.gettemporary_presensi());
        BtnPrint.setEnabled(akses.gettemporary_presensi());
        
        if(akses.getkode().equals("Admin Utama")){
            ppVerifyOtomatis.setEnabled(true);
        }else{
            ppVerifyOtomatis.setEnabled(false);
        } 
     }

}