package com.example.invoice.repository;

import com.example.invoice.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
