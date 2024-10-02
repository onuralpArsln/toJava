d.setColor(Color.BLACK); // Yazı rengi
        g2d.drawString("X: " + x + ", Y: " + y, 10, 20); // Pozisyon bilgisi
    }

    // Y eksenindeki hareketi kontrol eden metot
    public void moveShapeY(int direction) {
        this.y += Y_SPEED * direction; // Y ekseninde hareket ettir
        // Panele sığması için sınırlandırma
        if (this.y < 0) {
            this.y = 0;
        }
        if (this.y + 50 > this