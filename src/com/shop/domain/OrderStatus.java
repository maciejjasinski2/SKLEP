package com.shop.domain;

/**
 * Order statuses
 *
 * @author maciej.jasinski2@gmail.com
 * @since 24.11.2019
 */
public enum OrderStatus {
    IN_PROGRES("in progress"),
    SENT("sent");


        private String statusName;
        OrderStatus(String statusName) {
            this.statusName = statusName;
        }
        public String getStatusName() {
            return statusName;
        }
}
