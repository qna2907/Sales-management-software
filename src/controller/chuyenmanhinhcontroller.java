
package controller;
import bean.dmbean;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import qlbanhang.CTHDJPanel;
import qlbanhang.HDJPanel;
import qlbanhang.KHJPanel;
import qlbanhang.MNJPanel;
import qlbanhang.NVJPanel;
import qlbanhang.SPJPanel;
public class chuyenmanhinhcontroller {
    private final JPanel root;
    private String kindSelected = "";
    
    private List<dmbean> listItem = null;
    public chuyenmanhinhcontroller(JPanel jpnRoot){
        this.root = jpnRoot;     
    }
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSelected = "ChiTietHoaDon";
        //jpnItem.setBackground(new Color (96,100,191));
        //jlbItem.setBackground(new Color (255,0,51));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new CTHDJPanel());
        root.validate();
        root.repaint();
    }
    public void setEvent(List<dmbean> listItem){
        this.listItem = listItem;
        for(dmbean item : listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private final String kind;
        private final JPanel jpnItem;
        private final JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
           switch(kind){
               case "NhanVien":
                       node = new NVJPanel();
                       break;
               case "KhachHang":
                       node = new KHJPanel();
                       break;
               case "SanPham":
                       node = new SPJPanel();
                       break;
               case "HoaDon":
                       node = new HDJPanel();
                       break;
               case "ChiTietHoaDon":
                       node = new CTHDJPanel();
                       break;
               default:
                   node = new MNJPanel();
                   break;
           } 
           root.removeAll();
           root.setLayout(new BorderLayout());
           root.add(node);
           root.validate();
           root.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            //jpnItem.setBackground(new Color(96,100,191));
            //jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //jpnItem.setBackground(new Color(96,100,191));
            //jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if(!kindSelected.equalsIgnoreCase(kind)){
               //jpnItem.setBackground(new Color(76,175,80));
               //jlbItem.setBackground(new Color(76,175,80)); 
            }
        }
        private void setChangeBackground(String kind){
            for(dmbean item : listItem){
                if(item.getKind().equalsIgnoreCase(kind)){
                    //item.getJlb().setBackground(new Color(96,100,191));
                } else{        
                       //item.getJlb().setBackground(new Color(76,175,80));
                       //item.getJpn().setBackground(new Color(76,175,80));
                        }
            }
        }
    }
}
