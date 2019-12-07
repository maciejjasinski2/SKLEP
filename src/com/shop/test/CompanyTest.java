package com.shop.test;

import com.shop.domain.Company;
import com.shop.domain.VatNumber;

/**
 * ... comment class...
 *
 * @author kamil.jasek@gmail.com
 * @since 2019-11-17
 */
final class CompanyTest {

    void testCreateCompany() {
        Company company = new Company("Samsung", new VatNumber("PL0399300392"));
        assert company != null : "Company not created";
    }
}
