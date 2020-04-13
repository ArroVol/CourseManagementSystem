package edu.ben.cmsc3330.data.translator;

import edu.ben.cmsc3330.data.model.Address;
import edu.ben.cmsc3330.web.model.AddressView;

public class AddressTranslator {

    public static AddressView entityToView(final Address address) {
        return AddressView.builder()
                .street(address.getStreet())
                .city(address.getCity())
                .state(address.getState())
                .postalCode(address.getPostalCode())
                .build();
    }
}
