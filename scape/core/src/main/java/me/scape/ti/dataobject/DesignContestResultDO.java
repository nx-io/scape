package me.scape.ti.dataobject;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 景观规划设计赛事比赛结果.
 * 
 * @author fei.liu E-mail:fei.liu@andpay.me
 * 
 * @version 1.0.0
 * @since 2015年1月29日 下午2:25:39
 */
@Entity
@Table(name = "design_contest_result", catalog = "scape")
public class DesignContestResultDO implements Serializable {

    private static final long serialVersionUID = -6254857307014659510L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "contest_id", nullable = false)
    private Integer contest_id;// 赛事ID

    @Column(name = "entry_id", nullable = false)
    private Integer entry_id;// 作品ID

    @Column(name = "ranking", nullable = false)
    private Integer ranking;// 参赛作品排名

    @Column(name = "comment", nullable = false, length = 512)
    private String comment;// 参赛作品评语

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_created", nullable = false)
    private Date gmt_created;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "gmt_modified", nullable = true)
    private Date gmt_modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getContest_id() {
        return contest_id;
    }

    public void setContest_id(Integer contest_id) {
        this.contest_id = contest_id;
    }

    public Integer getEntry_id() {
        return entry_id;
    }

    public void setEntry_id(Integer entry_id) {
        this.entry_id = entry_id;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getGmt_created() {
        return gmt_created;
    }

    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((comment == null) ? 0 : comment.hashCode());
        result = prime * result + ((contest_id == null) ? 0 : contest_id.hashCode());
        result = prime * result + ((entry_id == null) ? 0 : entry_id.hashCode());
        result = prime * result + ((gmt_created == null) ? 0 : gmt_created.hashCode());
        result = prime * result + ((gmt_modified == null) ? 0 : gmt_modified.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((ranking == null) ? 0 : ranking.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DesignContestResultDO other = (DesignContestResultDO) obj;
        if (comment == null) {
            if (other.comment != null)
                return false;
        } else if (!comment.equals(other.comment))
            return false;
        if (contest_id == null) {
            if (other.contest_id != null)
                return false;
        } else if (!contest_id.equals(other.contest_id))
            return false;
        if (entry_id == null) {
            if (other.entry_id != null)
                return false;
        } else if (!entry_id.equals(other.entry_id))
            return false;
        if (gmt_created == null) {
            if (other.gmt_created != null)
                return false;
        } else if (!gmt_created.equals(other.gmt_created))
            return false;
        if (gmt_modified == null) {
            if (other.gmt_modified != null)
                return false;
        } else if (!gmt_modified.equals(other.gmt_modified))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (ranking == null) {
            if (other.ranking != null)
                return false;
        } else if (!ranking.equals(other.ranking))
            return false;
        return true;
    }
}