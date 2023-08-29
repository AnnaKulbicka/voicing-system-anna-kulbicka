package pl.futurecollars.invoicing.model;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

  @Id
  @ApiModelProperty(value = "Invoice id (generated by application)", required = true, example = "1")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ApiModelProperty(value = "Invoice number (assigned by user)", required = true, example = "2020/03/08/0000001")
  private String number;

  @ApiModelProperty(value = "Date invoice was created", required = true)
  private LocalDate date;

  @JoinColumn(name = "buyer")
  @OneToOne(cascade = CascadeType.ALL)
  @ApiModelProperty(value = "Company who bought the product/service", required = true)
  private Company buyer;

  @JoinColumn(name = "seller")
  @OneToOne(cascade = CascadeType.ALL)
  @ApiModelProperty(value = "Company who is selling the product/service", required = true)
  private Company seller;

  @ManyToMany
  @JoinTable(name = "invoiceinvoice_entry", joinColumns = @JoinColumn(name = "invoice_id"), inverseJoinColumns = @JoinColumn(name = "invoiceentryid"))
  @ApiModelProperty(value = "List of products/services", required = true)
  private List<InvoiceEntry> entries;

}

