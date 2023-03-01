/***************************************************************************************
 * @author <<Your Name>>
 * @Date 2013-02-11
 * @Version 1.0
 * @Purpose <<You have to write the comment the main purpose of this class>>
 *
 *
 ***************************************************************************************/
package org.ace.insurance.productservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.constant.TableName;
import org.ace.insurance.utilityservice.embeddable.UserRecorder;

import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@Table(name = TableName.CUR)
@NamedQueries(value = { @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c ORDER BY c.currencyCode ASC"),
		@NamedQuery(name = "Currency.findByCurrencyCode", query = "SELECT c FROM Currency c WHERE c.currencyCode = :currencyCode"),
		@NamedQuery(name = "Currency.findById", query = "SELECT c FROM Currency c WHERE c.id = :id") })
public class Currency implements Serializable {
	private static final long serialVersionUID = -6992572646153666363L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CURRENCY_GEN")
	private String id;

	@Column(name = "CUR")
	private String currencyCode;
	private String description;
	private String symbol;
	private String inwordDesp1;
	private String inwordDesp2;
	@Column(name = "HOMEINWORDDESP1")
	private String myanInwordDesp1;
	@Column(name = "HOMEINWORDDESP2")
	private String myanInwordDesp2;
	private Boolean isHomeCur;
	private float m1;
	private float m2;
	private float m3;
	private float m4;
	private float m5;
	private float m6;
	private float m7;
	private float m8;
	private float m9;
	private float m10;
	private float m11;
	private float m12;
	private float m13;
	@Embedded
	private UserRecorder recorder;
	@Version
	private int version;
}
