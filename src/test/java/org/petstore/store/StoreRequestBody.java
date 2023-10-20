package org.petstore.store;

public record StoreRequestBody(int id, int petId, int quantity, String shipDate, String status,
                               boolean complete) {

}
