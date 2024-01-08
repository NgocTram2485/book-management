/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package book.management.ui;

import book.management.models.Book;
import book.management.models.Category;
import book.management.models.Publisher;
import book.management.repository.BookRepository;
import book.management.repository.CategoryRepository;
import book.management.repository.PublisherRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dungnh
 */
public class Application extends JFrame {

    private BookRepository bookRepo;
    private CategoryRepository cateRepo;
    private PublisherRepository publisherRepo;

    private List<String> categories = new ArrayList<>();
    private Map<String, Integer> mapCategories = new HashMap<>();

    private List<String> publishers = new ArrayList<>();
    private Map<String, Integer> mapPublishers = new HashMap<>();

    private javax.swing.JButton addBtn;
    private javax.swing.JPanel authorLinePanel;
    private javax.swing.JLabel authorUpdateLabel;
    private javax.swing.JTextField authorUpdateTf;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton cancelUpdateBtn;
    private javax.swing.JPanel categoryLinePanel;
    private javax.swing.JComboBox<String> categoryUpdateCb;
    private javax.swing.JLabel categoryUpdateLabel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel nameLinePanel;
    private javax.swing.JLabel nameUpdateLabel;
    private javax.swing.JTextField nameUpdateTf;
    private javax.swing.JPanel priceLinePanel;
    private javax.swing.JLabel priceUpdateLabel;
    private javax.swing.JTextField priceUpdateTf;
    private javax.swing.JPanel publisherLinePanel;
    private javax.swing.JComboBox<String> publisherUpdateCb;
    private javax.swing.JLabel publisherUpdateLabel;
    private javax.swing.JPanel qtyLinePanel;
    private javax.swing.JLabel qtyUpdateLabel;
    private javax.swing.JTextField qtyUpdateTf;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTf;
    private javax.swing.JTable tbl;
    private javax.swing.JScrollPane tblScroll;
    private javax.swing.JButton updateBtn;
    private javax.swing.JPanel updatePanel;

    public Application() {
        bookRepo = new BookRepository();
        cateRepo = new CategoryRepository();
        publisherRepo = new PublisherRepository();

        initComponents();
        this.updatePanel.setVisible(false);

        initSelection();
    }

    private void initSelection() {
        List<Category> cateVals = cateRepo.listAll();
        for (Category c : cateVals) {
            this.categories.add(c.getName());
            this.mapCategories.put(c.getName(), c.getId());
        }

        List<Publisher> pubVals = publisherRepo.listAll();
        for (Publisher p : pubVals) {
            this.publishers.add(p.getName());
            this.mapPublishers.put(p.getName(), p.getId());
        }
    }

    /*
    setTitle("Book Management");
    setSize(1600, 800);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setTitle("Book Management");
        setSize(1600, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        headerPanel = new javax.swing.JPanel();
        searchTf = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        bodyPanel = new javax.swing.JPanel();
        tblScroll = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        updatePanel = new javax.swing.JPanel();
        nameLinePanel = new javax.swing.JPanel();
        nameUpdateLabel = new javax.swing.JLabel();
        nameUpdateTf = new javax.swing.JTextField();
        authorLinePanel = new javax.swing.JPanel();
        authorUpdateLabel = new javax.swing.JLabel();
        authorUpdateTf = new javax.swing.JTextField();
        priceLinePanel = new javax.swing.JPanel();
        priceUpdateLabel = new javax.swing.JLabel();
        priceUpdateTf = new javax.swing.JTextField();
        qtyLinePanel = new javax.swing.JPanel();
        qtyUpdateLabel = new javax.swing.JLabel();
        qtyUpdateTf = new javax.swing.JTextField();
        categoryLinePanel = new javax.swing.JPanel();
        categoryUpdateLabel = new javax.swing.JLabel();
        categoryUpdateCb = new javax.swing.JComboBox<>();
        publisherLinePanel = new javax.swing.JPanel();
        publisherUpdateLabel = new javax.swing.JLabel();
        publisherUpdateCb = new javax.swing.JComboBox<>();
        cancelUpdateBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        searchTf.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        searchBtn.setText("Search");
        searchBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchBtn.setSize(new java.awt.Dimension(90, 23));
        searchBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            searchBtnActionPerformed(evt);
        });

        addBtn.setText("Add");
        addBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addBtn.setSize(new java.awt.Dimension(90, 23));
        addBtn.addActionListener((java.awt.event.ActionEvent evt) -> {
            addBtnActionPerformed(evt);
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(headerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(searchTf, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        headerPanelLayout.setVerticalGroup(
                headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(searchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                        .addGroup(headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(addBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(searchTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        bodyPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbl.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null, null}
                },
                new String[]{
                    "No", "Name", "Author", "Price", "Qty", "Category", "Publisher", "Received Time", "Modified Time"
                }
        ));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        tblScroll.setViewportView(tbl);
        if (tbl.getColumnModel().getColumnCount() > 0) {
            tbl.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        updatePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nameLinePanel.setPreferredSize(new java.awt.Dimension(175, 50));

        nameUpdateLabel.setText("Name");

        javax.swing.GroupLayout nameLinePanelLayout = new javax.swing.GroupLayout(nameLinePanel);
        nameLinePanel.setLayout(nameLinePanelLayout);
        nameLinePanelLayout.setHorizontalGroup(
                nameLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(nameLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nameUpdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameUpdateTf)
                                .addContainerGap())
        );
        nameLinePanelLayout.setVerticalGroup(
                nameLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(nameLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(nameLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(nameLinePanelLayout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(nameUpdateTf, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                        .addComponent(nameUpdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        authorLinePanel.setPreferredSize(new java.awt.Dimension(175, 50));

        authorUpdateLabel.setText("Author");

        javax.swing.GroupLayout authorLinePanelLayout = new javax.swing.GroupLayout(authorLinePanel);
        authorLinePanel.setLayout(authorLinePanelLayout);
        authorLinePanelLayout.setHorizontalGroup(
                authorLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(authorLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(authorUpdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(authorUpdateTf)
                                .addContainerGap())
        );
        authorLinePanelLayout.setVerticalGroup(
                authorLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(authorLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(authorLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(authorLinePanelLayout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(authorUpdateTf, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                        .addComponent(authorUpdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        priceLinePanel.setPreferredSize(new java.awt.Dimension(175, 50));

        priceUpdateLabel.setText("Price");

        javax.swing.GroupLayout priceLinePanelLayout = new javax.swing.GroupLayout(priceLinePanel);
        priceLinePanel.setLayout(priceLinePanelLayout);
        priceLinePanelLayout.setHorizontalGroup(
                priceLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(priceLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(priceUpdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceUpdateTf)
                                .addContainerGap())
        );
        priceLinePanelLayout.setVerticalGroup(
                priceLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(priceLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(priceLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(priceLinePanelLayout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(priceUpdateTf, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                        .addComponent(priceUpdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        qtyLinePanel.setPreferredSize(new java.awt.Dimension(175, 50));

        qtyUpdateLabel.setText("Quantity");
        javax.swing.GroupLayout qtyLinePanelLayout = new javax.swing.GroupLayout(qtyLinePanel);
        qtyLinePanel.setLayout(qtyLinePanelLayout);
        qtyLinePanelLayout.setHorizontalGroup(
                qtyLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(qtyLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(qtyUpdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qtyUpdateTf)
                                .addContainerGap())
        );
        qtyLinePanelLayout.setVerticalGroup(
                qtyLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(qtyLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(qtyLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(qtyLinePanelLayout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(qtyUpdateTf, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                                        .addComponent(qtyUpdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        categoryLinePanel.setPreferredSize(new java.awt.Dimension(175, 50));

        categoryUpdateLabel.setText("Category");

        categoryUpdateCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        javax.swing.GroupLayout categoryLinePanelLayout = new javax.swing.GroupLayout(categoryLinePanel);
        categoryLinePanel.setLayout(categoryLinePanelLayout);
        categoryLinePanelLayout.setHorizontalGroup(
                categoryLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(categoryLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(categoryUpdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryUpdateCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        categoryLinePanelLayout.setVerticalGroup(
                categoryLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(categoryLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(categoryLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(categoryUpdateCb, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                        .addComponent(categoryUpdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        publisherLinePanel.setPreferredSize(new java.awt.Dimension(175, 50));

        publisherUpdateLabel.setText("Publisher");

        publisherUpdateCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        javax.swing.GroupLayout publisherLinePanelLayout = new javax.swing.GroupLayout(publisherLinePanel);
        publisherLinePanel.setLayout(publisherLinePanelLayout);
        publisherLinePanelLayout.setHorizontalGroup(
                publisherLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(publisherLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(publisherUpdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(publisherUpdateCb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        publisherLinePanelLayout.setVerticalGroup(
                publisherLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(publisherLinePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(publisherLinePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(publisherUpdateCb, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                                        .addComponent(publisherUpdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        cancelUpdateBtn.setText("Cancel");
        cancelUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelUpdateBtnActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");

        javax.swing.GroupLayout updatePanelLayout = new javax.swing.GroupLayout(updatePanel);
        updatePanel.setLayout(updatePanelLayout);
        updatePanelLayout.setHorizontalGroup(
                updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(updatePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nameLinePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                        .addComponent(authorLinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                        .addComponent(priceLinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                        .addComponent(qtyLinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                        .addComponent(categoryLinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                        .addComponent(publisherLinePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                        .addGroup(updatePanelLayout.createSequentialGroup()
                                                .addComponent(cancelUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        updatePanelLayout.setVerticalGroup(
                updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(updatePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nameLinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(authorLinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceLinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(qtyLinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryLinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(publisherLinePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addGroup(updatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelUpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
                bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bodyPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(tblScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(updatePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        bodyPanelLayout.setVerticalGroup(
                bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(updatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tblScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {
        List<Book> books;
        String search = searchTf.getText();
        if (search.isEmpty()) {
            books = bookRepo.listProduct();
        } else {
            books = bookRepo.searchBook(search);
        }
        renderTable(books);
    }

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {
        this.updatePanel.setVisible(true);
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        int row = tbl.getSelectedRow();
        nameUpdateTf.setText(model.getValueAt(row, 1).toString());
        authorUpdateTf.setText(model.getValueAt(row, 2).toString());
        priceUpdateTf.setText(model.getValueAt(row, 3).toString());
        qtyUpdateTf.setText(model.getValueAt(row, 4).toString());
        
        String selectedCategory = model.getValueAt(row, 5).toString();
        DefaultComboBoxModel cateComboBoxModel = new DefaultComboBoxModel(this.categories.toArray());
        categoryUpdateCb.setModel(cateComboBoxModel);
        categoryUpdateCb.setSelectedItem(selectedCategory);
        
        String selectedPublisher = model.getValueAt(row, 6).toString();
        DefaultComboBoxModel pubComboBoxModel = new DefaultComboBoxModel(this.publishers.toArray());
        publisherUpdateCb.setModel(pubComboBoxModel);
        publisherUpdateCb.setSelectedItem(selectedPublisher);
    }

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void cancelUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void renderTable(List<Book> books) {
        DefaultTableModel model = (DefaultTableModel) tbl.getModel();
        model.setRowCount(0);
        for (Book book : books) {
            model.addRow(new Object[]{
                book.getId(),
                book.getName(),
                book.getAuthor(),
                book.getPrice(),
                book.getQty(),
                book.getCategoryName(),
                book.getPublisherName(),
                book.getCreatedAt(),
                book.getUpdatedAt()
            });
        }
        bodyPanel.revalidate();
        bodyPanel.repaint();
    }
}
