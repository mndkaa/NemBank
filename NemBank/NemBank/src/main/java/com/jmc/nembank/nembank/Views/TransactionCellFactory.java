package com.jmc.nembank.nembank.Views;

import com.jmc.nembank.nembank.Controllers.Client.TransactionCellController;
import com.jmc.nembank.nembank.Models.Transaction;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class TransactionCellFactory extends ListCell<Transaction> {
    @Override
    protected void updateItem(Transaction transaction, boolean empty) {
        super.updateItem(transaction, empty);
        if (empty) {
            setText(null);
            setGraphic(null);
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/TransactionsCell.fxml"));
            TransactionCellController controller = new TransactionCellController(transaction);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
