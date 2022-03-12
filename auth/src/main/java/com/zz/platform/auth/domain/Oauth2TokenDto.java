package com.zz.platform.auth.domain;

public class Oauth2TokenDto {

    private String token;
    private String refreshToken;
    private String tokenHead;
    private int expiresIn;

    Oauth2TokenDto(final String token, final String refreshToken, final String tokenHead, final int expiresIn) {
        this.token = token;
        this.refreshToken = refreshToken;
        this.tokenHead = tokenHead;
        this.expiresIn = expiresIn;
    }

    public static Oauth2TokenDto.Oauth2TokenDtoBuilder builder() {
        return new Oauth2TokenDto.Oauth2TokenDtoBuilder();
    }

    public String getToken() {
        return this.token;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getTokenHead() {
        return this.tokenHead;
    }

    public int getExpiresIn() {
        return this.expiresIn;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public void setTokenHead(final String tokenHead) {
        this.tokenHead = tokenHead;
    }

    public void setExpiresIn(final int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String toString() {
        return "Oauth2TokenDto(token=" + this.getToken() + ", refreshToken=" + this.getRefreshToken() + ", tokenHead=" + this.getTokenHead() + ", expiresIn=" + this.getExpiresIn() + ")";
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Oauth2TokenDto)) {
            return false;
        } else {
            Oauth2TokenDto other = (Oauth2TokenDto)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$token = this.getToken();
                Object other$token = other.getToken();
                if (this$token == null) {
                    if (other$token != null) {
                        return false;
                    }
                } else if (!this$token.equals(other$token)) {
                    return false;
                }

                Object this$refreshToken = this.getRefreshToken();
                Object other$refreshToken = other.getRefreshToken();
                if (this$refreshToken == null) {
                    if (other$refreshToken != null) {
                        return false;
                    }
                } else if (!this$refreshToken.equals(other$refreshToken)) {
                    return false;
                }

                Object this$tokenHead = this.getTokenHead();
                Object other$tokenHead = other.getTokenHead();
                if (this$tokenHead == null) {
                    if (other$tokenHead != null) {
                        return false;
                    }
                } else if (!this$tokenHead.equals(other$tokenHead)) {
                    return false;
                }

                if (this.getExpiresIn() != other.getExpiresIn()) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Oauth2TokenDto;
    }

    public int hashCode() {
        int result = 1;
        Object $token = this.getToken();
        result = result * 59 + ($token == null ? 43 : $token.hashCode());
        Object $refreshToken = this.getRefreshToken();
        result = result * 59 + ($refreshToken == null ? 43 : $refreshToken.hashCode());
        Object $tokenHead = this.getTokenHead();
        result = result * 59 + ($tokenHead == null ? 43 : $tokenHead.hashCode());
        result = result * 59 + this.getExpiresIn();
        return result;
    }

    public static class Oauth2TokenDtoBuilder {
        private String token;
        private String refreshToken;
        private String tokenHead;
        private int expiresIn;

        Oauth2TokenDtoBuilder() {
        }

        public Oauth2TokenDto.Oauth2TokenDtoBuilder token(final String token) {
            this.token = token;
            return this;
        }

        public Oauth2TokenDto.Oauth2TokenDtoBuilder refreshToken(final String refreshToken) {
            this.refreshToken = refreshToken;
            return this;
        }

        public Oauth2TokenDto.Oauth2TokenDtoBuilder tokenHead(final String tokenHead) {
            this.tokenHead = tokenHead;
            return this;
        }

        public Oauth2TokenDto.Oauth2TokenDtoBuilder expiresIn(final int expiresIn) {
            this.expiresIn = expiresIn;
            return this;
        }

        public Oauth2TokenDto build() {
            return new Oauth2TokenDto(this.token, this.refreshToken, this.tokenHead, this.expiresIn);
        }

        public String toString() {
            return "Oauth2TokenDto.Oauth2TokenDtoBuilder(token=" + this.token + ", refreshToken=" + this.refreshToken + ", tokenHead=" + this.tokenHead + ", expiresIn=" + this.expiresIn + ")";
        }
    }

}
